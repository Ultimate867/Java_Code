package cmp342_HW2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings({ "serial", "unused" })
public class WestJPanel extends JPanel implements ActionListener{
	
	JButton jb1;
	
	JRadioButton jrbOFF ;
	JRadioButton jrbON ;

	
	public WestJPanel(){
		setBackground(Color.MAGENTA);
		setLayout(new GridLayout(3,1)); //May Need To Go
		JLabel myJL = new JLabel("West");
		
		ButtonGroup jbGroup = new ButtonGroup();//groups make 1 button choice selectable at a time
		jrbOFF = new JRadioButton("NO shapes");
		jrbOFF.setSelected(false);
		jrbOFF.setActionCommand("shapesOFF");
		jrbOFF.addActionListener(this);
		jbGroup.add(jrbOFF);
		
		jrbON = new JRadioButton("YES shapes");
		jrbON.setSelected(false);
		jrbON.setActionCommand("shapesON");
		jrbON.addActionListener(this);
		jbGroup.add(jrbON);

		add(myJL); //Original
		
		add(jrbOFF);
		add(jrbON);

		
//		jb1 = new JButton("Click me for MAGENTA");
//		jb1.addActionListener(this); //Remember This
//		add(jb1);
	}
	
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		String face = e.getActionCommand();
//		
//		if(face.equalsIgnoreCase("Click me for MAGENTA")){
//			
//			 Color initialBackground = jb1.getBackground();
//		        Color background = JColorChooser.showDialog(WestJPanel.this,
//		            "JColorChooser Sample", initialBackground);
//		        if (background != null) {
//		        	CircleDrawer1.circle_color = background;	    
//		            jb1.setBackground(background);
//		        }
//		      }
//
//		    jb1.setSize(500, 500);
//		    jb1.setVisible(true);
//		
//		if(face.equalsIgnoreCase("Click me for YELLOW")){
//			
//			this.setBackground(Color.yellow);
//		}
//
//		if(face.equalsIgnoreCase("Click me for GREEN")){
//	
//			this.setBackground(Color.green);
//		}
//	}
	
	
	
	/////////////Use Later for improvements
	@Override
	public void actionPerformed(ActionEvent e) {
		String btnClicked = e.getActionCommand();
//		
//		if(btnClicked.equalsIgnoreCase("Click me for MAGENTA")){
//			
//			 Color initialBackground = jb1.getBackground();
//		        Color background = JColorChooser.showDialog(WestJPanel.this,
//		            "JColorChooser Sample", initialBackground);
//		        if (background != null) {
//		        	CircleDrawer1.circle_color = background;	    
//		            jb1.setBackground(background);
//		        }
//		      }
//
//		    jb1.setSize(500, 500);
//		    jb1.setVisible(true);
		    
		System.out.println("the command was: "+btnClicked);
		switch(btnClicked){
		case "shapesON":
			Drawing.drawShapes = true;
			break;
		case "shapesOFF":
			Drawing.drawShapes = false;
			break;
		default:
			Drawing.drawShapes = false;
			System.out.print("ONLY FOR DEBUGGING... shape radio buttons not found");
			break;
		}
		
	}

}