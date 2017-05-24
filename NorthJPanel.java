package cmp342_HW2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * 
 Each JPanel should have a different background color,
 and some text stating which panel it is. 
 (the default layout for JPanel is FlowLayout)
 */
@SuppressWarnings({ "serial", "unused" })
public class NorthJPanel extends JPanel implements ActionListener{
	
	JButton jb1;
	JButton jb2;
	JButton jb3;
	
	public NorthJPanel(){
		setBackground(Color.BLUE);
		JLabel myJL = new JLabel("North");
		add(myJL);
		
		//JButton jb1;
		jb1 = new JButton("Square");

		jb1.addActionListener(this); //Remember This
		add(jb1);
		
		//JButton jb2;
		jb2 = new JButton("Circle");

		jb2.addActionListener(this); //Remember This
		add(jb2);
				
		//JButton jb3;
		jb3 = new JButton("Triangle");

		jb3.addActionListener(this); //Remember This
		add(jb3);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String face = e.getActionCommand();
		
		if(e.getSource()== jb1){
			
		   Drawing.shape = "Square";
		   
		}
		
		if(e.getSource()== jb2){
			
			   Drawing.shape = "Circle";
			   
			}
		
		if(e.getSource()== jb3){
			
			   Drawing.shape = "Triangle";
			   
			}
		
//		if(face.equalsIgnoreCase("Circle")){
//			
//			Drawing.shape = "Circle";
//		}
//		
//		if(face.equalsIgnoreCase("Triangle")){
//			
//			Drawing.shape = "Triangle";
//		}
	}


	
	}

