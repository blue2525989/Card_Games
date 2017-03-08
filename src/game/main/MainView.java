package game.main;

import java.awt.Color;
import java.awt.Point;

import javax.swing.*;

public class MainView {

	// main frame to hold everything together
	public JFrame main = new JFrame();
	// jpanel to hold components inside of frame
	private JPanel mainPane = new JPanel();
	// prompt
	private JLabel header = new JLabel("Please choose a game.");
	// buttons
	public JButton poker = new JButton("Poker");
	public JButton blackjack = new JButton("BlackJack");
	public JButton exit = new JButton("Exit");
	// point for screen location
	private Point p1 = new Point(500,200);
	
	// loads all components
	public void loadView() {
		// add all components to the jpanel
		mainPane.add(header);
		mainPane.add(poker);
		mainPane.add(blackjack);
		mainPane.add(exit);
		// change background and foreground colors
		mainPane.setBackground(Color.DARK_GRAY);
		header.setForeground(Color.MAGENTA);
		// add everything to main frame, set size, set location, set close operation
		main.add(mainPane);
		main.setVisible(true);
		main.setSize(160,300);
		main.setLocation(p1);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
