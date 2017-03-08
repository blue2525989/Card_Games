package game;
	
import game.poker.Controller;
import game.main.MainController;
import game.model.PokerCard;
import game.model.BlackJackCard;

import game.blackjack.BlackJackController;

public class Main {

	// instances of helper classes for poker
	PokerCard card = new PokerCard();
	Controller con = new Controller();
	// instances of helper classes for blackjack
	BlackJackCard bjcard = new BlackJackCard();
	BlackJackController con2 = new BlackJackController();
	// main controller
	MainController maincon = new MainController();
	
	// constructor
	public Main() {
		// calls loadView from view class
		maincon.view.loadView();		
	}
	
	//------MAIN METHOD------//
	public static void main(String[] args) {
		new Main();
	}
}
