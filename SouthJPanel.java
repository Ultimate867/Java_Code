package cmp342_HW2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class SouthJPanel extends Drawing implements ActionListener{//Remember
	
	JButton jb1;
	JButton jb2;
	JButton jb3;
	
	public SouthJPanel(){
		setBackground(Color.RED);
		JLabel myJL = new JLabel("South");
		add(myJL);
		
		jb1 = new JButton("Shape Color");
		jb1.addActionListener(this); //Remember This
		add(jb1);
		
		jb2 = new JButton("Line Color");
		jb2.addActionListener(this); //Remember This
		add(jb2);
		
		jb3 = new JButton("Letter Color");
		jb3.addActionListener(this); //Remember This
		add(jb3);
	}
	
	public void actionPerformed(ActionEvent e) {//Replace Circledrawer with Drawing
		// TODO Auto-generated method stub
		String face = e.getActionCommand();
		
		if(face.equalsIgnoreCase("Shape Color")){
				
	   Color initialBackground = jb1.getBackground();
	   Color background = JColorChooser.showDialog(SouthJPanel.this,
			            "JColorChooser Sample", initialBackground);
			        if(background != null) {
			        	Drawing.circle_color = background;	    
			            //jb1.setBackground(background);
			          
			        }    
			        
			   // jb1.setSize(500, 500);
			   // jb1.setVisible(true);
		}
		
		
		if(face.equalsIgnoreCase("Line Color")){
			
			   Color initialBackground = jb2.getBackground();
			   Color background = JColorChooser.showDialog(SouthJPanel.this,
					            "JColorChooser Sample", initialBackground);
					        if(background != null) {
					        	Drawing.line_color = background;	    
					            //jb2.setBackground(background);
					          
					        }    
					        
					    //jb2.setSize(500, 500);
					   //jb2.setVisible(true);
				}
		
		if(face.equalsIgnoreCase("Letter Color")){
			
			   Color initialBackground = jb3.getBackground();
			   Color background = JColorChooser.showDialog(SouthJPanel.this,
					            "JColorChooser Sample", initialBackground);
					        if(background != null) {
					        	DrawAndType.letter_color = background;	    
					            //jb3.setBackground(background);
					          
					        }    
					        
					   // jb3.setSize(500, 500);
					   // jb3.setVisible(true);
				}
	}
}