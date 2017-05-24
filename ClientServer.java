import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientServer extends Thread {
    public  static int port;
    public  static String host;
    private static Socket socket;
    private DataInputStream strIn;
    private DataOutputStream strOut;
    public static String username;
    public boolean connected;

    public ClientServer(String username){
        this.socket = null;
        this.port  = 8080;
        this.host = "localhost";
        this.strIn = null;
        this.strOut  = null;
        this.username = username;

        start();
    }
    
    // Run Thread
    public void run(){
        // Try to connect to the server
        connected = false;
        try{
            socket         = new Socket(host, port);

            strOut = new DataOutputStream(socket.getOutputStream());
            strOut.flush();
            strIn = new DataInputStream(socket.getInputStream());
            send(username);
            connected = true;

            ClientMain.clientFrame.btnConnect.setEnabled(false);
            ClientMain.clientFrame.btnSend.setEnabled(true);
            ClientMain.clientFrame.btnQuit.setEnabled(true);
            ClientMain.clientFrame.setTitle(username + " chat");
            ClientMain.clientFrame.appendText(ClientMain.clientFrame.displayText,
                    username + ", you are now connected to the server.\n\n");
        } catch(IOException ex){
                ClientMain.clientFrame.appendText(ClientMain.clientFrame.displayText,
                    "Unable to connect to the server.\n" + ex.getMessage() + "\n\n");
        }

        // Listen for messages from the server
        while(connected){
            try{
                String line = strIn.readUTF();
                String message = "";
                String msgFrom = "";
                int index = 0;
                for(int i = 0; i < line.length(); i++){
                    char c = line.charAt(i);
                    String ch = "" + c;

                    if(ch.equals("/")) break;
                    if(ch.equals("!")) break; //New Code
                    
                    else{
                        msgFrom += ch;
                        index++;
                    }
                }
                message = msgFrom + ": " + line.substring(index+1,line.length()) + "\n"; //Problematic
                ClientMain.clientFrame.appendText(ClientMain.clientFrame.displayText, message);
            } catch(IOException ex){
                if(connected){
                    ClientMain.clientFrame.appendText(ClientMain.clientFrame.displayText,
                        "You have been disconnected from the server.");
                    break;
                }
            }
        }
        if(connected){
            disconnect();
            connected = false;
        }
    }

    public void send(String line){
        try{
            strOut.writeUTF(line);
            strOut.flush();
        } catch (IOException e) {
            if(connected){
                ClientMain.clientFrame.appendText(ClientMain.clientFrame.displayText,
                    "Unable to send message!\n" + e.getMessage() + "\n");
            }
        }
    }

    public void disconnect(){
        if(strOut != null){
            send("bye");
        }
        ClientMain.clientFrame.resetGUI();
    }

    public void closeAll(){
        try{
            if(strIn != null)  strIn.close();
            if(strOut != null) strOut.close();
            if(socket != null) socket.close();
        } catch (IOException e){
            ClientMain.clientFrame.appendText(ClientMain.clientFrame.displayText,
                    "Unable to close:" + '\n' + e.getMessage() + "\n\n");
        }
    }
}