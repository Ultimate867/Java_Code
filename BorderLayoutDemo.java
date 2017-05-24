package cmp342_HW2;

import javax.swing.JApplet;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class BorderLayoutDemo extends JApplet{ //JPanel
	
	public BorderLayoutDemo(){ //init
		
		setBackground(Color.WHITE);
		
		add(new JButton("North Region"), BorderLayout.NORTH);
		add(new JButton("South Region"), BorderLayout.SOUTH);
		add(new JButton("East Region"), BorderLayout.EAST);
		add(new JButton("West Region"), BorderLayout.WEST);
		add(new JButton("Center Region"), BorderLayout.CENTER);
	}

}
