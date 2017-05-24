package cmp342_HW2;

//package circledrawingexamples;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CircleDrawer1 extends JPanel implements MouseListener{

	private int circleSize = 40;
	protected static Color circle_color;
	private int lastX=0, lastY=0;
	
	public CircleDrawer1(){
		setBackground(Color.WHITE);
		addMouseListener(this);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
		lastY = e.getY();
		Graphics g = getGraphics();
		Graphics2D g2d = (Graphics2D)g;
		//g2d.setColor(Color.RED);
		g2d.setColor(circle_color);
		//g2d.fillOval(lastX, lastY, circleSize, circleSize);
		// notice cirlce is NOT drawn around the click
		g2d.fillOval(lastX-(circleSize/2), lastY-(circleSize/2), circleSize, circleSize);
		//g2d.fillRect(lastX-(circleSize/2), lastY-(circleSize/2), circleSize, circleSize);//same idea for other shapes
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}

