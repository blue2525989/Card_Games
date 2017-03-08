package game.main;

import java.awt.event.*;
import game.blackjack.BlackJackController;
import game.poker.Controller;

public class MainController implements ActionListener{

	// main view
	public MainView view = new MainView();
	// I put these instances of helper classes here to access the loadView
	// from each controller.
	BlackJackController conbj = new BlackJackController();
	Controller conp = new Controller();
	
	public MainController () {
		// add action listeners
		view.blackjack.addActionListener(this);
		view.poker.addActionListener(this);
		view.exit.addActionListener(this);
	}
	
	// where all the action happens
	public void actionPerformed(ActionEvent event) {
		/*
		 * Poker button
		 * loads poker game
		 */
		
		if (event.getSource() == view.poker) {
			conp.view.loadView();
			view.main.setVisible(false);
		}
		
		/*
		 * BlackJack button
		 * loads blackjack game
		 */
		
		if (event.getSource() == view.blackjack) {
			conbj.view.loadView();
			view.main.setVisible(false);
		}
		
		/*
		 * Exit button
		 * exits game
		 */
		
		if (event.getSource() == view.exit) {
			System.exit(0);
		}
	}
}
