package cmp342_HW2;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class DrawAndType extends Drawing implements KeyListener{
	
	public static FontMetrics fm;
	protected static int fontSize = 10; //500
	protected static Color letter_color;
	protected static Font font = new Font("Serif",Font.ITALIC,fontSize);
	static Font newFont = font.deriveFont(font.getSize() * 1.5F);
	
	public DrawAndType(){
		
		super();
		addKeyListener(this);
		fm = getFontMetrics(font);//
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
//		String s = String.valueOf( arg0.getKeyChar() );
//		Graphics g = getGraphics();
//		g.setColor(Color.RED);
//		//JColorChooser will be used to change this color stored in a variable
//		g.drawString(s, getX(), getY());
//		record( getX(), getY());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		String s = String.valueOf( arg0.getKeyChar() );
		Graphics g = getGraphics();
		g.setColor(letter_color);
		
		//To write over multiple lines //fm.getHeight();//New Code
		//JColorChooser will be used to change this color stored in a variable
		g.setFont(new Font("Serif",Font.ITALIC,fontSize));//Possible Fix 2
		g.drawString(s, getLastX(), getLastY());
		
		record( getLastX()+fm.stringWidth(s), getLastY()); //getx and y or getLast X and Y
		
	}

}
