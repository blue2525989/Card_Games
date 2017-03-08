package game.main;

import java.awt.event.*;
import game.blackjack.BlackJackController;
import game.poker.Controller;

public class MainController implements ActionListener{

	public MainView view = new MainView();
	BlackJackController conbj = new BlackJackController();
	Controller conp = new Controller();
	public MainController () {
		view.blackjack.addActionListener(this);
		view.poker.addActionListener(this);
		view.exit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == view.poker) {
			conp.view.loadView();
			view.main.setVisible(false);
		}
		
		if (event.getSource() == view.blackjack) {
			conbj.view.loadView();
			view.main.setVisible(false);
		}
		
		if (event.getSource() == view.exit) {
			System.exit(0);
		}
	}
}
