package game.main;

import java.awt.Color;

import javax.swing.*;

public class MainView {

	public JFrame main = new JFrame();
	
	private JPanel mainPane = new JPanel();
	private JLabel header = new JLabel("Please choose a game.");
	
	public JButton poker = new JButton("Poker");
	public JButton blackjack = new JButton("BlackJack");
	public JButton exit = new JButton("Exit");
	
	public void loadView() {
		mainPane.add(header);
		mainPane.add(poker);
		mainPane.add(blackjack);
		mainPane.add(exit);
		mainPane.setBackground(Color.DARK_GRAY);
		header.setForeground(Color.MAGENTA);
		
		main.add(mainPane);
		main.setVisible(true);
		main.setSize(160,300);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
