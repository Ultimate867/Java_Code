package cmp342_HW2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
	
	@SuppressWarnings({ "serial", "unused" })
	public class EastJPanel extends Drawing implements ActionListener{//Used to entend JPanel
		
		JButton jb1;
		JButton jb2;
		JButton jb3;
		JButton jb4;
		JButton jb5;
		JButton jb6;
		
		Font original;
		
		public EastJPanel(){
			
			setLayout(new GridLayout(6,1));//REMEMBER THIS
			
			setBackground(Color.CYAN);
			JLabel myJL = new JLabel("East");
			add(myJL);
			
			jb1 = new JButton("Increase Shape Size");
			jb1.addActionListener(this); //Remember This
			add(jb1);
			
			jb2 = new JButton("Decrease Shape Size");
			jb2.addActionListener(this); //Remember This
			add(jb2);
			
//			JLabel myJL2 = new JLabel("East2");
//			add(myJL2);
			
			//Change Letter Size
			jb3 = new JButton("Increase Letter Size");
			jb3.addActionListener(this); //Remember This
			add(jb3);
			
			jb4 = new JButton("Decrease Letter Size");
			jb4.addActionListener(this); //Remember This
			add(jb4);
			
			//Change Line Size
			
			jb5 = new JButton("Increase Line Size");
			jb5.addActionListener(this); //Remember This
			add(jb5);
			
			jb6 = new JButton("Decrease Line Size");
			jb6.addActionListener(this); //Remember This
			add(jb6);
			
			setSize(500,500);
			
			
		}
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String face = e.getActionCommand();
			
			if(face.equalsIgnoreCase("Increase Shape Size")){
			   DrawAndType.circleSize += 10;
			  System.out.println( DrawAndType.circleSize);
			   
			}
			
			if(face.equalsIgnoreCase("Decrease Shape Size")){
				 DrawAndType.circleSize -= 10;
				   System.out.println( DrawAndType.circleSize);
				   
			}
			
			//Change Letter Size
			
			if(face.equalsIgnoreCase("Increase Letter Size")){//Not Working
				  System.out.println( DrawAndType.fontSize + " Force");
				 // original = new Font("Serif",Font.ITALIC,DrawAndType.fontSize);
				  //DrawAndType.font = original.deriveFont(DrawAndType.fontSize);
				  DrawAndType.font = new Font("Serif",Font.ITALIC,  DrawAndType.fontSize);
				  DrawAndType.fontSize += 5;
				  System.out.println(DrawAndType.fontSize);
				   
			}
				
			if(face.equalsIgnoreCase("Decrease Letter Size")){//Not Working
				DrawAndType.fontSize -= 5;
				  System.out.println( DrawAndType.fontSize + " Force2");
				 // original = new Font("Serif",Font.ITALIC,DrawAndType.fontSize);
				  //DrawAndType.font = original.deriveFont(DrawAndType.fontSize);
				  DrawAndType.font = new Font("Serif",Font.ITALIC,  DrawAndType.fontSize);
				  System.out.println(DrawAndType.fontSize);
					   
			}
			
			//Change Line Size
			
			if(face.equalsIgnoreCase("Increase Line Size")){
				 DrawAndType.width += 10;
				  System.out.println( DrawAndType.circleSize);
				   
			}
				
			if(face.equalsIgnoreCase("Decrease Line Size")){
				 DrawAndType.width -= 10;
				System.out.println( DrawAndType.circleSize);
					   
			}
			
			
			
//			String face = e.getActionCommand();
//			
//			if(face.equalsIgnoreCase("Click me for CYAN")){
//				
//				 Color initialBackground = jb1.getBackground();
//			        Color background = JColorChooser.showDialog(EastJPanel.this,
//			            "JColorChooser Sample", initialBackground);
//			        if (background != null) {
//			        	CircleDrawer1.circle_color = background;	    
//			            jb1.setBackground(background);
//			        }
//			      }
//
//			    jb1.setSize(500, 500);
//			    jb1.setVisible(true);
			    
		}

}