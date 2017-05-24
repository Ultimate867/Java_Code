package cmp342_HW2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class Drawing extends JPanel implements MouseListener, MouseMotionListener{

	protected static Color circle_color;
	protected static String shape = "Circle";//protected
	protected static Color line_color;
	protected static int circleSize = 40; //Used to be private and 40
	private int lastX=0, lastY=0;
	private int times=0;
	protected static boolean drawShapes = false;
	
	protected static float width = 20;
	
	public Drawing(){
		setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println("X IS "+x+ "Y IS "+y);
		Graphics g = getGraphics();
		Graphics g2d = (Graphics2D)g;
		((Graphics2D) g2d).setStroke(new BasicStroke(width));//use a variable that will have the line width
		g2d.setColor(line_color);  //use a variable that will have the drawing color
		g2d.drawLine(lastX, lastY, x, y);
		record(x,y);
		
	}
	protected void record(int x, int y){
		lastX = x;
		lastY = y;
	}
	
	//get the last x and y
	public int getLastX(){
		
		return lastX;
	}
	
	public int getLastY(){
		
		return lastY;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {//New Code
		// TODO Auto-generated method stub
		
		record(e.getX(), e.getY());		//need for typing
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		if(drawShapes){
			times++;
			record(e.getX(), e.getY()); //store the lastX and lastY values
			//lastX = e.getX();
			//lastY = e.getY();
			Graphics g = getGraphics();
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(circle_color);
			//g2d.scale(circleSize, circleSize);
			//g2d.fillOval(lastX, lastY, circleSize, circleSize);
			// notice circle is NOT drawn around the click
			
			if(shape == "Circle"){
				
				g2d.fillOval(lastX-( circleSize/2), lastY-(circleSize/2), circleSize, circleSize);
				System.out.println("Tri1");
			}
			
			if(shape == "Square"){
				
				g2d.fillRect(lastX-( circleSize/2), lastY-(circleSize/2), circleSize, circleSize);
				System.out.println("Tri2");
			}
			
			if(shape == "Triangle"){
				
				//draw a triangle.... polygon
				//int [] xs =  {lastX-(circleSize/2) ,lastX+(circleSize/2), lastX};
			    //int [] ys = {lastY-(circleSize/2),lastY-(circleSize/2),lastY+(circleSize/2)};
				g2d.fillPolygon(new Polygon(
	                    new int[]{50, circleSize, 0},
	                    new int[]{0, circleSize, circleSize},
	                    3)
);
				System.out.println("Tri3"); //circleSize instead of 100
			
			}
			
			
			//g2d.fillRect(lastX-(circleSize/2), lastY-(circleSize/2), circleSize, circleSize);//same idea for other shapes
			//draw a hollow circle
			//g2d.setStroke(new BasicStroke(10));
			//g2d.drawOval(lastX-(circleSize/2), lastY-(circleSize/2), circleSize, circleSize);
			/*
			//draw a triangle.... polygon
			int [] xs =  {lastX-(circleSize/2) ,lastX+(circleSize/2), lastX};
		    int [] ys = {lastY-(circleSize/2),lastY-(circleSize/2),lastY+(circleSize/2)};
			g2d.fillPolygon(xs , ys,3);
			*/
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {//New Code
		
		// TODO Auto-generated method stub
		
		requestFocus();
		record(e.getX(), e.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}