package cmp342_HW2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings({ "serial", "unused" })
public class BoxLayoutExample extends JPanel{

	private BoxLayout layout;
	
	private JButton topButton, middleButton, bottomButton;
	
	public BoxLayoutExample(){
		
		//layout = new BoxLayout(this, BoxLayout.X_AXIS);
		layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);
		
		JLabel label = new JLabel("Using BoxLayout");
		
		topButton = new JButton("Top");
		middleButton = new JButton("Middle");
		bottomButton = new JButton("Bottom");
		
		add(label);
		add(topButton);
		add(middleButton);
		add(bottomButton);
		
		setBackground(Color.WHITE);
	}
	
}
