package cmp342_HW2;
	
	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;

	public class CircleDrawerAdapter extends MouseAdapter{

		private int circleSize = 40;
		private int lastX=0, lastY=0;
		
		@Override
		public void mousePressed(MouseEvent e){
			lastX = e.getX();
			lastY = e.getY();
			Graphics g = e.getComponent().getGraphics();
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(Color.BLUE);
			g2d.fillOval(lastX-(circleSize/2), lastY-(circleSize/2), circleSize, circleSize);
			
		}
	}
