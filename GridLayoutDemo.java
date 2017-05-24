package cmp342_HW2;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class GridLayoutDemo extends JPanel{
	
	//@Override
	
	public GridLayoutDemo(){ //init
		
		JPanel jp = new JPanel();
		
		jp.setLayout( new GridLayout(3,2) );
		
		jp.setBackground(Color.WHITE);
		
		JButton jb;
		
		for(int i = 0; i < 6; i++){
			
			int index = i + 1;
			
			jb = new JButton(" button" + index+" ");
			
			jp.add(jb);
		}
		
		add(jp);
	}

}
