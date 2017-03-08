package game.blackjack;

/**
 * black jack controller
 */
import java.awt.event.*;

import game.model.BlackJackCard;
import game.model.Card;

import javax.swing.JOptionPane;
public class BlackJackController implements ActionListener{
	
	// instances of helper classes
	private BlackJackCard card = new BlackJackCard();
	public View view = new View();
		
	// Card Arrays to hold hands, pre-set to hold up to eleven cards for when you get
	// nothing but twos. 2 + 2 + 2 + 2 + 2 + 2 + 2 + 2 + 2 + 2 = 20 so the eleventh 
	// card surely will bust or be 21.
	//
	// players hand
	private Card[] phand = card.newHand();
	// dealers hand
	private Card[] chand = card.newHand();

	// constructor
	public BlackJackController() {
		// button listeners as well as disabling yes button and no button until game begins
		view.deal.addActionListener(this);
		view.yes.addActionListener(this);
		view.yes.setEnabled(false);
		view.no.addActionListener(this);
		view.no.setEnabled(false);
		view.exit.addActionListener(this);
		// starting message
		view.setGame("Welcome to Black Jack!\n"
				+ "Press deal to play.");
	}
	
	// where all the action happens
	public void actionPerformed(ActionEvent event) {
		
		/**
		 * Deal button.
		 * Deals two cards to the dealer and the player at random.
		 */
		
		if (event.getSource() == view.deal) {
			// clears text area first
			view.clear();
			// empties hand each time
			// player hand
			for (int i = 0; i < phand.length; i++) {
				if (phand[i] != null) {
					phand[i] = null;
				}
			}
			// computer hand
			for (int j = 0; j < chand.length; j++) {
				if (chand[j] != null) {
					chand[j] = null;
				}
			}
			
			// enabled buttons
			view.deal.setEnabled(false);
			view.yes.setEnabled(true);
			view.no.setEnabled(true);
			
			// deal new hand
			card.deal(phand, chand);			
			
			
			// blackjack conditions
			// player black jack
			if (card.isBlackjack(phand)) {
				view.setGame("Player Black Jack!!!\n");
				view.deal.setEnabled(true);
				view.yes.setEnabled(false);
				view.no.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Player BlackJack!!!");
			}
			// dealer black jack
			else if (card.isBlackjack(chand)) {
				view.setGame("Dealer Black Jack.\n");
				view.deal.setEnabled(true);
				view.yes.setEnabled(false);
				view.no.setEnabled(false);
							
			}
			// display game data
			view.setGame("Alright here we go, Good luck.\n");
			view.setGame("Player's cards, " + card.getHand(phand) + "\nTotal of: " + card.getTotal(phand));
			view.setGame("Dealer's cards, " + card.getHand(chand) + "\nTotal of: " + card.getTotal(chand));
			
		}

			/**
			 * Yes button
			 * each time yes is clicked it adds one card to
			 * the player's hand
			 */
			
		if (event.getSource() == view.yes) {
			// a random card to use
			Card rcard = card.randomCard();
			Card ace = card.ace(rcard);
			// add the random card
			int total = card.getTotal(phand);
			// changes ace value to 1 if total over 11
			if (total > 11 && rcard.getRank() == 11) {
				card.addtoHand(phand, ace);

				// busted conditions
				if (card.isBusted(phand)) {
					view.setGame("\nPlayers hit: " + card.getHit(phand));
					view.setGame("Total of: " + card.getTotal(phand));
					view.setGame("Player busted with a total of, " + card.getTotal(phand) + "\n");
					view.setGame("Dealer wins with a total of, " +card.getTotal(chand));
					view.yes.setEnabled(false);
					view.no.setEnabled(false);
					view.deal.setEnabled(true);
				}
				// blackjack conditions
				else if (card.isBlackjack(phand)) {
					view.setGame("\nPlayers hit: " + card.getHit(phand));
					view.setGame("Total of: " + card.getTotal(phand));
					view.setGame("Player wins with Black Jack!!!\n");
					view.deal.setEnabled(true);
					view.yes.setEnabled(false);
					view.no.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Player BlackJack!!!");
				}
				// hit conditions
				else {
					view.setGame("\nPlayers hit: " + card.getHit(phand));
					view.setGame("Total of: " + card.getTotal(phand));
					view.setGame("Would you like to hit again?");
				}
				
			}
			// regular ace if total is under 11
			else if (total < 11 && rcard.getRank() == 11) {
				card.addtoHand(phand, rcard);
				
				// busted conditions
				if (card.isBusted(phand)) {
					view.setGame("\nPlayers hit: " + card.getHit(phand));
					view.setGame("Total of: " + card.getTotal(phand));
					view.setGame("Player busted with a total of, " + card.getTotal(phand) + "\n");
					view.setGame("Dealer wins with a total of, " +card.getTotal(chand));
					view.yes.setEnabled(false);
					view.no.setEnabled(false);
					view.deal.setEnabled(true);
				}
				// blackjack conditions
				else if (card.isBlackjack(phand)) {
					view.setGame("\nPlayers hit: " + card.getHit(phand));
					view.setGame("Total of: " + card.getTotal(phand));
					view.setGame("Player wins with Black Jack!!!\n");
					view.deal.setEnabled(true);
					view.yes.setEnabled(false);
					view.no.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Player BlackJack!!!");
				}
				// hit conditions
				else {
					view.setGame("\nPlayers hit: " + card.getHit(phand));
					view.setGame("Total of: " + card.getTotal(phand));
					view.setGame("Would you like to hit again?");
				}
			}
			// adds card if not an ace
			else {
				card.addtoHand(phand, rcard);
				// busted conditions
				if (card.isBusted(phand)) {
					view.setGame("\nPlayers hit: " + card.getHit(phand));
					view.setGame("Total of: " + card.getTotal(phand));
					view.setGame("Player busted with a total of, " + card.getTotal(phand) + "\n");
					view.setGame("Dealer wins with a total of, " +card.getTotal(chand));
					view.yes.setEnabled(false);
					view.no.setEnabled(false);
					view.deal.setEnabled(true);
				}
				// blackjack conditions
				else if (card.isBlackjack(phand)) {
					view.setGame("\nPlayers hit: " + card.getHit(phand));
					view.setGame("Total of: " + card.getTotal(phand));
					view.setGame("Player wins with Black Jack!!!\n");
					view.deal.setEnabled(true);
					view.yes.setEnabled(false);
					view.no.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Player BlackJack!!!");
				}
				// hit conditions
				else {
					view.setGame("\nPlayers hit: " + card.getHit(phand));
					view.setGame("Total of: " + card.getTotal(phand));
					view.setGame("Would you like to hit again?");
				}
				
			}
		}
		
		/**
		 * No button
		 * the no button makes the dealer take its turn.
		 * it will continue to hit until its total is at
		 * or above 17
		 */
		
		if (event.getSource() == view.no) {
			// computer takes hits until total is 17 or above
			while (card.getTotal(chand) < 17) {		
				// random card to use
				Card rcard = card.randomCard();
				
				// add random card to hand
				card.addtoHand(chand, rcard);
				
				// busted conditions
				if (card.isBusted(chand)) {
					view.setGame("Dealers hit: " + card.getHit(chand));
					view.setGame("Total of: " + card.getTotal(chand));
					view.setGame("Dealer busted with a total of, " + card.getTotal(chand) + "\n");
					view.setGame("Player wins with a total of, " +card.getTotal(phand));
					view.yes.setEnabled(false);
					view.no.setEnabled(false);
					view.deal.setEnabled(true);
				}
				// blackjack conditions
				else if (card.isBlackjack(chand)) {
					view.setGame("Dealers hit: " + card.getHit(chand));
					view.setGame("Total of: " + card.getTotal(chand));
					view.setGame("Dealer wins with Black Jack." + card.getTotal(chand) + "\n");
					view.deal.setEnabled(true);
					view.yes.setEnabled(false);
					view.no.setEnabled(false);
				}
				// hit conditions
				else {
					view.setGame("Dealers hit: " + card.getHit(chand));
					view.setGame("Total of: " + card.getTotal(chand) + "\n");
				}
			}
			// win conditions
			// if players total is under 21 but above dealers total
			if (card.getTotal(phand) < 21 && card.getTotal(phand) > card.getTotal(chand)) {
				view.setGame("Player wins with a total of, " +card.getTotal(phand));
				view.deal.setEnabled(true);
				view.yes.setEnabled(false);
				view.no.setEnabled(false);
			}
			// if dealers total is under 21 but above players total
			else if (card.getTotal(phand) < card.getTotal(chand) && card.getTotal(chand) < 21) {
				view.setGame("Dealer wins with a total of, " +card.getTotal(chand));
				view.deal.setEnabled(true);
				view.yes.setEnabled(false);
				view.no.setEnabled(false);
			}
			// if dealer and player are the same
			else if (card.getTotal(phand) == card.getTotal(chand)){
				view.setGame("Push. Player's total is " + card.getTotal(phand) + " Dealer's total is " + card.getTotal(chand));
				view.deal.setEnabled(true);
				view.yes.setEnabled(false);
				view.no.setEnabled(false);
			}
			
		}
		
		/**
		 * Exit button
		 * exits the program.
		 */
		
		if (event.getSource() == view.exit) {
			System.exit(0);
		}
	}
}