package cmp342_HW2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.net.*;

import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class CardPanel_Swing extends JPanel{
	
	private JLabel name;
	private ImageLabel picture;
	
	public CardPanel_Swing (String cardName,  String imageFile){// URL directory, String imageFile){
		
		setLayout(new BorderLayout() );
		name = new JLabel(cardName, JLabel.CENTER);
		add(name, BorderLayout.NORTH);
		picture = new ImageLabel(imageFile);
		JPanel picturePanel = new JPanel();
		picturePanel.add(picture);
		add(picturePanel, BorderLayout.CENTER);
		setSize(getPreferredSize());
	}
	
	public JLabel getLabel(){
		
		return (name);
	}
	
	public ImageLabel getImageLabel(){
		
		return (picture);
	}

	//New Code
	
	private JLabel myJL;
	
	public CardPanel_Swing (){
		setBackground(Color.BLUE);
		 myJL = new JLabel("General");
		add(myJL);
	}
	
	public CardPanel_Swing (String text){
		setBackground(Color.BLUE);
		 myJL = new JLabel(text);
		add(myJL);
	}
	
	public CardPanel_Swing (String text, Color col){
		setBackground(col);
		 myJL = new JLabel(text);
		add(myJL);
	}

}


