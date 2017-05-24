package cmp342_HW2;

import java.awt.Color;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings({ "unused", "serial" })
public class FlowLayoutDemo extends JPanel{ //JApplet
	
	//@Override
	
	public FlowLayoutDemo(){
		
		JPanel jp = new JPanel();
		
		JButton jb;
		
		for(int i = 0; i < 5; i++){
			
			int index = i+1;
			
			jb = new JButton(" button" + index+" ");
			jp.add(jb);
		}
		
		add(jp);
	}

}
