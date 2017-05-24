package cmp342_HW2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings({ "unused", "serial" })
public class Card_JFrame extends JFrame{
	
	public Card_JFrame(){
		
		//New Code
		DrawAndType dat = new DrawAndType();
		//End Of New Code
		
		JPanel mainPanel = new JPanel();
		
		NorthJPanel MP5 = new NorthJPanel();
		
		SouthJPanel MP4 = new SouthJPanel();
		
		EastJPanel MP3 = new EastJPanel();
		
		WestJPanel MP2 = new WestJPanel();
		
		CenterJPanel MP1 = new CenterJPanel();
		
       mainPanel.setBackground(Color.WHITE);

       mainPanel.setLayout(new BorderLayout());//Remember this
		mainPanel.add(BorderLayout.NORTH, MP5);
		mainPanel.add(BorderLayout.SOUTH, MP4);
		mainPanel.add(BorderLayout.EAST, MP3);
		mainPanel.add(BorderLayout.WEST, MP2);
		mainPanel.add(BorderLayout.CENTER, MP1);
	
		add(mainPanel);

		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

}
