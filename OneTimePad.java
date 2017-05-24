public class OneTimePad {
	
	private String plainMessage ="";
	private String encryptedMessage = "";
	private String currentKey="";
	
	public OneTimePad(){
		setPlainMessage("no message");
		setCurrentKey(generateKey(getPlainMessage()));
		setEncryptedMessage(encrypt(getPlainMessage()));
	}
	
	public OneTimePad(String msg){
		setPlainMessage(msg);
		setCurrentKey(generateKey(msg));
		setEncryptedMessage(encrypt(msg));
	}
	
	private int getNumFromChar(char c){
		return Character.valueOf(c);
	}
	
	private char getCharFromNum(int num){
		return Character.toChars(num)[0];
	}
	
	public String encrypt(String plainMsg){
		String encMsg = "";
		for(int i=0; i<plainMsg.length(); i++){
		int numForPlainChar = getNumFromChar(plainMsg.charAt(i));//get num from plain char
		int numForKeyChar = getNumFromChar(getCurrentKey().charAt(i));//get num from the key's char
		int numForEncChar = numForPlainChar + numForKeyChar;
		char encryptedChar = getCharFromNum(numForEncChar); 
		encMsg += encryptedChar;// append the char to out encrypted message
		}
		return encMsg;
	}
	
	public String decrypt(String encMsg){
		String decMsg = "";
		for(int i=0; i<encMsg.length(); i++){
			int numForEncChar = getNumFromChar(encMsg.charAt(i));
			int numForKeyChar = getNumFromChar(getCurrentKey().charAt(i));
			int numForPlainChar = numForEncChar - numForKeyChar;
			char plainChar = getCharFromNum(numForPlainChar);
			decMsg += plainChar;
		}
		return decMsg;
	}
	
	public String generateKey(String plainMsg){
		String key = "";
		for(int i=0; i<plainMsg.length(); i++){
			int randNum = 64 + (int)(Math.random()*26);
			key += getCharFromNum(randNum);
		}
		return key;
	}
	public String getPlainMessage() {
		return plainMessage;
	}
	public void setPlainMessage(String plainMessage) {
		this.plainMessage = plainMessage;
	}
	public String getCurrentKey() {
		return currentKey;
	}
	public void setCurrentKey(String currentKey) {
		this.currentKey = currentKey;
	}
	public String getEncryptedMessage() {
		return encryptedMessage;
	}
	public void setEncryptedMessage(String encryptedMessage) {
		this.encryptedMessage = encryptedMessage;
	}
	
	public static void main(String [] args){
		//OneTimePad otp = new OneTimePad("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		OneTimePad otp = new OneTimePad("Hello");
		System.out.println("The Plain Message: "+ otp.plainMessage);
		System.out.println("The Key for the  Message: "+ otp.currentKey);
		String encMsg = otp.encryptedMessage;
		System.out.println("The Encrypted Message: "+ encMsg );
		
		System.out.println("The Plain Message: "+ otp.decrypt(encMsg));
	}
	
}