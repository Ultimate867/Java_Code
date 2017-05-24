package cmp342_HW2;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

//import cmp342HW.HelloWorld;

@SuppressWarnings({ "unused", "serial" })
public class Driver extends JFrame{
		
		public Driver(){
			CircleDrawer1 cd = new CircleDrawer1();
			add(cd);
			//Drawing sd = new Drawing();//
			//add(sd);//
			setSize(500,500);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
		}


	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			
			public void run(){
				
//				Driver cd = new Driver();
				
				//Drawing test1 = new Drawing();//
				//add(test1);//
				
				Card_JFrame test1 = new Card_JFrame();
				
				test1.setSize(500, 500);
				
				test1.setVisible(true);
			}
		
		}
				);
	}


	}
