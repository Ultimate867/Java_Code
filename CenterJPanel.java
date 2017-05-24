package cmp342_HW2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings({ "serial", "unused" })
public class CenterJPanel extends DrawAndType{//Remember CircleDrawer1
	
	public CenterJPanel(){
		
		setBackground(Color.WHITE);
		JLabel myJL = new JLabel("Center");
		add(myJL);
		
//		CircleDrawer1 cd = new CircleDrawer1();
//		add(cd);
		setSize(500,500);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String face = e.getActionCommand();
		
		if(face.equalsIgnoreCase("Click me for RED")){
			
			this.setBackground(Color.red);
		}
		
		if(face.equalsIgnoreCase("Click me for YELLOW")){
			
			this.setBackground(Color.yellow);
		}

		if(face.equalsIgnoreCase("Click me for GREEN")){
	
			this.setBackground(Color.green);
		}
	}
}