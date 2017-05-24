package cmp342_HW2;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class CardDemo_Swing extends JFrame implements ActionListener{ //extends JAPPlet
	
	private JButton first, last, previous, next;
	
	private String[] cardLabels = {"Jack", "Queen", "King", "Ace"};
	
	private CardPanel_Swing[] cardPanels = new CardPanel_Swing[4];
	
	private CardLayout layout;
	
	private JPanel cardDisplayJPanel;
	
	public CardDemo_Swing(){ //init()
		
		setBackground(Color.white);
		setLayout(new BorderLayout());
		addJButtonJPanel();
		addCardDisplayJPanel();
	}
	
	private void addJButtonJPanel(){
		
		JPanel JButtonJPanel = new JPanel();
		
		JButtonJPanel.setLayout(new GridLayout(9,1));
		
		Font JButtonFont = new Font("SansSerif", Font.BOLD,18);
		
		JButtonJPanel.setFont(JButtonFont);
		
		for(int i=0; i < cardLabels.length;i++){
			
			JButton JButton = new JButton(cardLabels[i]);
			JButton.addActionListener(this);
			JButtonJPanel.add(JButton);
		}
		
		first = new JButton("First");
		last = new JButton("Last");
		previous = new JButton("Previous");
		next = new JButton("Next");
		
		JButtonJPanel.add(new JLabel("---------", JLabel.CENTER));
		
		JButtonJPanel.add(first);
		JButtonJPanel.add(last);
		JButtonJPanel.add(previous);
		JButtonJPanel.add(next);
		
		add(JButtonJPanel, BorderLayout.WEST);
		
		add(JButtonJPanel, BorderLayout.EAST);
		
		add(JButtonJPanel, BorderLayout.CENTER);
		
		add(JButtonJPanel, BorderLayout.NORTH);
		
		add(JButtonJPanel, BorderLayout.SOUTH);
		
	}
	
	private void addCardDisplayJPanel(){
		
		cardDisplayJPanel = new JPanel();
		layout = new CardLayout();
		cardDisplayJPanel.setLayout(layout);
		String cardName;
		
		for(int i = 0; i < cardLabels.length; i++){
			
			cardName = cardLabels[i];
			cardPanels[i] = new CardPanel_Swing(cardName, "images/" + cardName + ".gif");
			
			cardDisplayJPanel.add(cardPanels[i], cardName);
		}
		
		add(cardDisplayJPanel, BorderLayout.CENTER);
		
		add(cardDisplayJPanel, BorderLayout.NORTH);
		
		add(cardDisplayJPanel, BorderLayout.SOUTH);
		
		add(cardDisplayJPanel, BorderLayout.EAST);
		
		add(cardDisplayJPanel, BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String name = e.getActionCommand();
		
		if(name.equals("North")){
			
			cardDisplayJPanel.setBackground(Color.BLUE);
		}
		
	}

}
