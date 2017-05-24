package cmp342_HW2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class RectangleDrawer extends JPanel implements MouseListener {
	
	private int circleSize = 40;
	private int lastX=0, lastY=0;
	
	public RectangleDrawer(){
		setBackground(Color.WHITE);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		lastX = e.getX();
		lastY = e.getY();
		Graphics g = e.getComponent().getGraphics();
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.BLUE);
		g2d.fillRect(lastX-(circleSize/2), lastY-(circleSize/2), circleSize, circleSize);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
