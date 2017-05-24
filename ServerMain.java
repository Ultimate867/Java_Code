import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ServerMain extends JFrame implements Runnable {
    public static ServerMain server;
    private int port;
    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream strIn = null;
    private DataOutputStream strOut = null;
    private static ArrayList clients;
    private static JTextPane txtArea;
    private JScrollPane scrollBar;

    public ServerMain(){
        this.port         = 8080;
        this.socket       = null;
        this.serverSocket = null;
        txtArea = new JTextPane();
        clients = new ArrayList();

        txtArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        txtArea.setFont(new Font("Dialog", Font.PLAIN, 14));
        txtArea.setEditable(false);

        // Scroll Bar
        scrollBar = new JScrollPane(txtArea);
        scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollBar.setBorder(null);

        add(scrollBar);
        run();
    }

    @Override
    public void run() {
        new Thread(()->{
            try{
                // Create New Server Socket
                serverSocket = new ServerSocket(port);

                appendText("Server started...waiting for a client.\n");

                while(true){
                    // Create New Socket
                    socket = serverSocket.accept();

                    // Create New Output/Input Streams
                    strOut = new DataOutputStream(socket.getOutputStream());
                    strOut.flush();

                    if(clients.size() < 50){
                    	
                    	
                        strIn = new DataInputStream(socket.getInputStream());

                        // Listen for data
                        String username = strIn.readUTF();
                        handleNewClient(username);
                    }
                    else{
                        strOut.writeUTF("terminate-The server is full, please try again later.");
                        strOut.flush();
                    }
                }
            }catch(IOException ex){
                appendText("I/O Exception: \n" + ex.getMessage() + "\n\n");
            }
        }).start();
    }

    private void handleNewClient(String username){
        // Create and start a new thread for the connection
        if(findClient(username)!= null){
            appendText(username + " is already connected to the server.\n");
        }
        else{
            // Client does not exist, so create new client
            ServerClient newClient = new ServerClient(socket, strIn, strOut, username);
            clients.add(newClient);
            appendText(username + " has connected to the server.\n");
        }
    }

    public static void handleMessage(String msgFrom, String input){
        String msgTo = "";
        String message = "";

        // Check if it is a private message
        if(input.length() >= 6 && input.substring(0,6).equals("secret")){
            int index = 6;
            for(int i = 6; i < input.length(); i++){
                char c = input.charAt(i);
                String ch = "" + c;
                if(ch.equals("/")){
                    break;
                }
                
                //Encrypted Msg
                else if(ch.equals("!")){
                	
                	break;
                }
                //End of New Code

                else{
                    msgTo += ch;
                    index++;
                }
            }
            // Build the message with the username the message is from
            //message = msgFrom + input.substring(index,input.length());

            //message = input.substring(index,input.length());
            message = msgFrom + input.substring(index,input.length());
            
          //New Code for OneTimePad
            OneTimePad otp = new OneTimePad( message );
        	
    		String msg =  otp.getPlainMessage();
    		String msg_key = otp.getCurrentKey();
    		String encMsg = otp.getEncryptedMessage();
    		String decMsg = otp.decrypt(encMsg);
    		
    		System.out.println(msg);
    		System.out.println(msg_key);
    		System.out.println(encMsg);
    		System.out.println(decMsg);
    		//End of New Code

            // Find the client to send the message to
            ServerClient client = findClient(msgTo);
            if(client != null) {
                appendText("Found client to send message" + msgTo + "\n");
                client.send(decMsg); //client.send(message); decMsg
            }
            
            appendText(msgFrom + " sent a private message to " + msgTo + ":" + msg + "\n");
            appendText(msgFrom + " sent a encrypted message to " + msgTo + ":" + encMsg + "\n");
            appendText(msgFrom + " sent a decrypted message to " + msgTo + ":" + msg_key + "\n");
            appendText(msgFrom + " sent a decrypted message to " + msgTo + ":" + decMsg + "\n");
            
            
            //New Lines
        }
        else if(input.length() >= 3 && input.substring(0,3).equals("bye")){
            // Check if the message is bye
            ServerClient client = findClient(msgFrom);
            if(client != null)
                remove(client);
        }
        else{
            // Send group message
            message = msgFrom + "/" + input;
            sendGroupMsg(message);
            appendText(msgFrom + " sent a public message." + "\n");
        }
    }

    // Remove A Client
    public static synchronized void remove(ServerClient client){ clients.remove(client); }

    // Find A Client
    public static synchronized ServerClient findClient(String username){
        Iterator i = clients.iterator();
        while(i.hasNext()){
            ServerClient client = (ServerClient) i.next();
            if(client.username.equals(username))
                return client;
        }
        return null;
    }

    // Send Group Message
    private static synchronized void sendGroupMsg(String message){
        Iterator i = clients.iterator();
        while(i.hasNext()){
            ServerClient client = (ServerClient) i.next();
            client.send(message);
        }
    }

    // Append Text To JTextPane
    public static void appendText(String message){
        txtArea.setEditable(true);
        SimpleAttributeSet attribute = new SimpleAttributeSet();
        StyleConstants.setForeground(attribute, Color.BLACK);

        int len = txtArea.getDocument().getLength();
        txtArea.setCaretPosition(len);
        txtArea.setCharacterAttributes(attribute, false);
        txtArea.replaceSelection(message);
        txtArea.setEditable(false);
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                server = new ServerMain();
                server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                server.setTitle("Chat Server!");
                server.setSize(600, 400);
                server.setLocationRelativeTo(null);
                server.setFocusable(true);
                server.setVisible(true);
            }
        });
    }
}