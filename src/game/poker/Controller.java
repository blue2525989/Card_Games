package game.poker;

/**
 * poker controller
 */

import java.awt.event.*;

import java.util.*;

import javax.swing.JOptionPane;

import game.model.Card;
import game.model.PokerCard;
import game.poker.View;

public class Controller implements ActionListener{

	// instance of poker card class
	PokerCard card = new PokerCard();
	
	// instance of view class
	public View view = new View();
	
	// new hands
	private Card[] phand = card.newHandPoker();
	private Card[] chand = card.newHandPoker();
	// new deck, new deck for holding combos
	private ArrayList<Card> deck;
	private ArrayList<Card> combo;
	// array to save names of card so not affected by random numbers
	// also helps when updating the cards after hits or calls
	String[] cardNames = new String[10];
	
	// counters for score
	private int playerScore = 0;
	private int dealerScore = 0;
	// string for holding winning combo for end game message
	private String playersCombo = "";
	private String dealersCombo = "";
	// counters for player combos
	private int twoKind;
	private int twoPair;
	private int threeKind;
	private int fullHouse;
	private int fourKind;
	private int straight;
	// counter for dealer combos
	private int ctwoKind;
	private int ctwoPair;
	private int cthreeKind;
	private int cfullHouse;
	private int cfourKind;
	private int cstraight;
	
	// constructor
	public Controller() {
		
		// button listeners as well as disabling yes and no buttons until game begins.
		view.deal.addActionListener(this);
		view.yes.addActionListener(this);
		view.no.addActionListener(this);
		view.exit.addActionListener(this);
		view.yes.setEnabled(false);
		view.no.setEnabled(false);
		
		// intial starting display
		view.setGame("Welcome to Five Card Poker!\n"
				+ "Press the deal button to play.");
		
		// intial starting prompt
		view.setMiddle("Two of a kind: " + 0 +"\t" + "Dealer Two of a kind: " + 0 +"\n"
				+ "Three of a kind: " + 0 + "\t"+ "Dealer Three of a kind: " + 0 + "\n"
				+ "Four of a kind: " + 0 + "\t" + "Dealer Four of a kind: " + 0 + "\n"
			    + "Two Pair's: " + 0 + "\t\t" + "Dealer Two Pair's: " + 0 + "\n"
			    + "Straight: " + 0 + "\t\t" + "Dealer Straight: " + 0 + "\n"
			    + "Full House: " + 0 + "\t\t" + "Dealer Full House: " + 0);
	}
	
	public void actionPerformed(ActionEvent event) {
		// try statement to catch NumberFormatException
		try {
			
		/**
		 * DEAL CARDS BUTTON
		 * 
		 * deals each player 5 cards at random from a 52 card deck.
		 * resets and checks for scores as well for dealer and player.
		 * 
		 */
			
		if (event.getSource() == view.deal) {
			view.clear();
			// intial starting prompt
			view.setMiddle("Two of a kind: " + 0 +"\t" + "Dealer Two of a kind: " + 0 +"\n"
					+ "Three of a kind: " + 0 + "\t"+ "Dealer Three of a kind: " + 0 + "\n"
					+ "Four of a kind: " + 0 + "\t" + "Dealer Four of a kind: " + 0 + "\n"
				    + "Two Pair's: " + 0 + "\t\t" + "Dealer Two Pair's: " + 0 + "\n"
				    + "Straight: " + 0 + "\t\t" + "Dealer Straight: " + 0 + "\n"
				    + "Full House: " + 0 + "\t\t" + "Dealer Full House: " + 0);
			// reset counter to ZERO
			twoKind = 0;
			threeKind = 0;
			fourKind = 0;
			twoPair = 0;
			fullHouse = 0;
			straight = 0;
			playerScore = 0;
			// reset counter to ZERO
			ctwoKind = 0;
			cthreeKind = 0;
			cfourKind = 0;
			ctwoPair = 0;
			cfullHouse = 0;
			cstraight = 0;
			dealerScore = 0;
			// initialize deck
			deck = card.newDeck(52);
			// deal 5 cards to player and dealer
			deck = card.dealPoker(deck, phand, chand);
			// save player card names for updating prompt
			cardNames[0] = card.saveCardName(phand[0]);
			cardNames[1] = card.saveCardName(phand[1]);
			cardNames[2] = card.saveCardName(phand[2]);
			cardNames[3] = card.saveCardName(phand[3]);
			cardNames[4] = card.saveCardName(phand[4]);
			// save dealer card names for updating prompt
			cardNames[5] = card.saveCardName(chand[0]);
			cardNames[6] = card.saveCardName(chand[1]);
			cardNames[7] = card.saveCardName(chand[2]);
			cardNames[8] = card.saveCardName(chand[3]);
			cardNames[9] = card.saveCardName(chand[4]);
			// checks for combos
			for (int j = 0; j < 1; j++) {
				// two of a kind
				if (card.checkPairs(phand) == 1) {
					twoKind += 1;
					playerScore = 1;
					playersCombo = "Two of a kind.";
				}
				// two pairs
				else if (card.checkPairs(phand) == 2) {
					twoPair += 1;
					playerScore = 2;
					playersCombo = "Two pairs.";
				}
				// three of a kind
				else if (card.checkPairs(phand) == 6) {
					threeKind += 1;
					playerScore = 3;
					playersCombo = "Three of a kind.";
				}
				// four of a kind
				else if (card.checkPairs(phand) == 12) {
					fourKind += 1;
					playerScore = 6;
					playersCombo = "Four of a kind.";
					JOptionPane.showMessageDialog(null, "Four of a kind!");
				}
				// full house
				else if (card.checkPairs(phand) == 4 || card.checkPairs(phand) == 8){
					fullHouse += 1;
					playerScore = 4;
					playersCombo = "Full house.";
					JOptionPane.showMessageDialog(null, "Full House!!");
				}
				else if (card.straight(phand) == 1) {
					straight += 1;
					playerScore = 5;
					playersCombo = "Straight.";
					JOptionPane.showMessageDialog(null, "Straight!!");
				}
			}
			// check for combos and update dealer score
			for (int j = 0; j < 1; j++) {
				// two of a kind
				if (card.checkPairs(chand) == 1) {
					ctwoKind = 1;
					dealerScore = 1;
					dealersCombo = "Two of a kind.";
				}
				// two pairs
				else if (card.checkPairs(chand) == 2) {
					ctwoPair = 1;
					dealerScore = 2;
					dealersCombo = "Two pairs.";
				}
				// three of a kind
				else if (card.checkPairs(chand) == 6) {
					cthreeKind = 1;
					dealerScore = 3;
					dealersCombo = "Three of a kind.";
				}
				// four of a kind
				else if (card.checkPairs(chand) == 12) {
					cfourKind = 1;
					dealerScore = 6;
					dealersCombo = "Four of a kind.";
				}
				// full house
				else if (card.checkPairs(chand) == 4 || card.checkPairs(chand) == 8){
					cfullHouse = 1;
					dealerScore = 4;
					dealersCombo = "Full house.";
				}
				// straight 
				else if (card.straight(chand) == 1) {
					cstraight = 1;
					dealerScore = 5;
					dealersCombo = "Straight.";
				}
			}
			
			// displays players and dealers hands in text area
			view.setGame("Player's cards, \n" + cardNames[0] + " " + cardNames[1] + 
					" " + cardNames[2] + " " + cardNames[3] + " " + cardNames[4]);
			view.setGame("Dealer's cards,\n" + cardNames[5] + " " + cardNames[6] + 
					" " + cardNames[7] + " " + cardNames[8] + " " + cardNames[9]);
			
			// intial starting prompt
			view.setMiddle("Two of a kind: " + twoKind +"\t" + "Dealer Two of a kind: " + ctwoKind +"\n"
					+ "Three of a kind: " + threeKind + "\t"+ "Dealer Three of a kind: " + cthreeKind + "\n"
					+ "Four of a kind: " + fourKind + "\t" + "Dealer Four of a kind: " + cfourKind + "\n"
				    + "Two Pair's: " + twoPair + "\t\t" + "Dealer Two Pair's: " + ctwoPair + "\n"
				    + "Straight: " + straight + "\t\t" + "Dealer Straight: " + cstraight + "\n"
				    + "Full House: " + fullHouse + "\t\t" + "Dealer Full House: " + cfullHouse);
			
			// enable buttons
			view.yes.setEnabled(true);
			view.no.setEnabled(true);
		}
		
		/**
		 * TAKE A HIT BUTTON
		 * 
		 * allows player to take a hit. 3 cards if no ace, 4 cards if ace is present.
		 * checks and updates scores.
		 * 
		 */
		
		if (event.getSource() == view.yes) {
			// turn off button so can only hit once
			view.yes.setEnabled(false);
			
			// reset counter to ZERO
			twoKind = 0;
			threeKind = 0;
			fourKind = 0;
			twoPair = 0;
			fullHouse = 0;
			straight = 0;
			playerScore = 0;
						
			// initialize numCards outside of loop for use later
			int numCards = 0;
			
			// gets card's rank to see if ace or not to determine amount of 
			// cards that can be swapped
			int zerorank = 0;
			for (int i = 0; i < phand.length; i++) {
				if (phand[i].getRank() == 1) {
					zerorank = 1;
				}
			}
			
			// if there is an ace
			if (zerorank == 1) {
				String numcards = JOptionPane.showInputDialog(null, "Enter the number of cards to swap up too 4.");
				numCards = Integer.parseInt(numcards);
				// if choice is more than 4 changes it to 4
				if (numCards > 4) {
					numCards = 4;
					JOptionPane.showMessageDialog(null, "Ace allows four cards to be swapped.\n"
							+ "Number changed to four.");
				}
			}
			// if first card is not an ace
			else {
				String numcards = JOptionPane.showInputDialog(null, "Enter the number of cards to swap up too 3.");
				numCards = Integer.parseInt(numcards);
				// if choice is more than 3 changes it to 3
				if (numCards > 3) {
					numCards = 3;
					JOptionPane.showMessageDialog(null, "No Ace, only three cards allowed to be swapped.\n"
							+ "Number changed to three.");
				}
			}
			
			// loop for checking if there are cards to be swapped
			// if numCards > 0 then it goes through the loop
			for (int i = 0; i < numCards; i++) {
				
				// get a number of a card to swap
				String choice = JOptionPane.showInputDialog("Please enter the number of the card [0,1,2,3,4]\n"
						+ "Numbers greater then 4 will be converted to 4.");
				
				// change string to integer
				int spot = Integer.parseInt(choice);
				
				// change choice to 4 if greater than
				if (spot > 4) {
					spot = 4;
				}
				
				// finds current spot of card chosen to swap
				int sc = phand[spot].getSuit();
				int rc = phand[spot].getRank();
				card.hitPoker(phand, new Card(sc, rc));
				
				// save new name of card to card array
				cardNames[spot] = card.saveCardName(phand[spot]);
				
				// displays cards before hit
				for (int m = 0; m < 1; m++) {
					if (i == 1) {
						// set game data
						view.setGame("\nPlayer's cards, \n" + phand[0].toString() + " " + phand[1].toString() + 
								" " + phand[2].toString() + " " + phand[3].toString() + " " + phand[4].toString());
					}
				}				
			}

			// sets game data
			view.setGame("Players hit, \n" + cardNames[0] + " " + cardNames[1] + 
					" " + cardNames[2] + " " + cardNames[3] + " " + cardNames[4]);
			
			
			// checks for combos
			for (int j = 0; j < 1; j++) {
				// two of a kind
				if (card.checkPairs(phand) == 1) {
					twoKind = 1;
					playersCombo = "Two of a kind.";
					playerScore = 1;
				}
				// two pairs
				else if (card.checkPairs(phand) == 2) {
					twoPair += 1;
					playersCombo = "Two pairs.";
					playerScore = 2;
				}
				// three of a kind
				else if (card.checkPairs(phand) == 6) {
					threeKind = 1;
					playerScore = 3;
					playersCombo = "Three of a kind.";
				}
				// four of a kind
				else if (card.checkPairs(phand) == 12) {
					fourKind = 1;
					playerScore = 6;
					playersCombo = "Four of a kind.";
					JOptionPane.showMessageDialog(null, "Four of a kind!");
				}
				// full house
				else if (card.checkPairs(phand) == 4 || card.checkPairs(phand) == 8){
					fullHouse = 1;
					playerScore = 4;
					playersCombo = "Full house.";
					JOptionPane.showMessageDialog(null, "Full House!!");
				}
				// straight
				else if (card.straight(phand) == 1) {
					straight = 1;
					playerScore = 5;
					playersCombo = "Straight.";
					JOptionPane.showMessageDialog(null, "Straight!!");
				}				
			}
			
			// prompt
			view.setMiddle("Two of a kind: " + twoKind +"\t" + "Dealer Two of a kind: " + ctwoKind +"\n"
					+ "Three of a kind: " + threeKind + "\t"+ "Dealer Three of a kind: " + cthreeKind + "\n"
					+ "Four of a kind: " + fourKind + "\t" + "Dealer Four of a kind: " + cfourKind + "\n"
				    + "Two Pair's: " + twoPair + "\t\t" + "Dealer Two Pair's: " + ctwoPair + "\n"
				    + "Straight: " + straight + "\t\t" + "Dealer Straight: " + cstraight + "\n"
				    + "Full House: " + fullHouse + "\t\t" + "Dealer Full House: " + cfullHouse);
			// disable deal button
			view.deal.setEnabled(false);
			
		}
		
		/**
		 * DON'T TAKE A HIT BUTTON
		 * 
		 * checks to see if computer has any combos
		 * and then decides to hit or not.
		 *  
		 */
		
		if (event.getSource() == view.no) {			
			// conditions for dealer hit
			for (int m = 0; m < 1; m++) {

				// set dealers cards again
				view.setGame("\nDealer's cards,\n" + cardNames[5] + " " + cardNames[6] + 
						" " + cardNames[7] + " " + cardNames[8] + " " + cardNames[9]);
				
				// if zero combos
				if (dealerScore == 0) {
					// swaps 1, 3 and 5 cards in hand
					card.hitPoker(chand, chand[0]);
					card.hitPoker(chand, chand[2]);
					card.hitPoker(chand, chand[4]);
				}
				// two of a kind
				else if (ctwoKind == 1) {
					combo = card.findCombos(chand);
					Card[] combos = new Card[15];
					// get combos
					for (int i = 0; i < combo.size(); i++) {
						combos[i] = combo.get(i);
					}
					// swap cards
					for (int j = 0; j < chand.length; j++) {
						if (combos[0] != chand[j]) {
							if (combos[1] != chand[j]) {
								card.hitPoker(chand, chand[j]);
							}
						}
						else if (combos[1] != chand[j]) {
							if (combos[0] != chand[j]) {
								card.hitPoker(chand, chand[j]);
							}
						}
					}
					
				}
				// three of a kind
				else if(cthreeKind == 1) {
					combo = card.findCombos(chand);
					Card[] combos = new Card[15];
					// get combos
					for (int i = 0; i < combo.size(); i++) {
						combos[i] = combo.get(i);						
					}
					// swap cards
					for (int j = 0; j < chand.length; j++) {
						if (combos[0] != chand[j]) {
							if (combos[1] != chand[j]) {
								if (combos[2] != chand[j]) {
									card.hitPoker(chand, chand[j]);
								} 
							}
						}
						else if (combos[1] != chand[j]) {
							if (combos[0] != chand[j]) {
								if (combos[2] != chand[j]) {
									card.hitPoker(chand, chand[j]);
								} 
							}
						}
						else if (combos[2] != chand[j]) {
							if (combos[0] != chand[j]) {
								if (combos[1] != chand[j]) {
									card.hitPoker(chand, chand[j]);
								} 
							}
						}
					}
				}
				// four of a kind
				else if (cfourKind == 1) {
					combo = card.findCombos(chand);
					Card[] combos = new Card[15];
					// gets combos
					for (int i = 0; i < combo.size(); i++) {
						combos[i] = combo.get(i);						
					}
					// swap cards
					for (int j = 0; j < chand.length; j++) {
						if (combos[0] != chand[j]) {
							if (combos[1] != chand[j]) {
								if (combos[2] != chand[j]) {
									if (combos[3] != chand[j]) {
										card.hitPoker(chand, chand[j]);
									}
								} 
							}
						}
						else if (combos[1] != chand[j]) {
							if (combos[0] != chand[j]) {
								if (combos[2] != chand[j]) {
									if (combos[3] != chand[j]) {
										card.hitPoker(chand, chand[j]);
									}
								} 
							}
						}
						else if (combos[2] != chand[j]) {
							if (combos[0] != chand[j]) {
								if (combos[1] != chand[j]) {
									if (combos[3] != chand[j]) {
										card.hitPoker(chand, chand[j]);
									}
								} 
							}
						}
						else if (combos[3] != chand[j]) {
							if (combos[1] != chand[j]) {
								if (combos[2] != chand[j]) {
									if (combos[0] != chand[j]) {
										card.hitPoker(chand, chand[j]);
									}
								} 
							}
						}
					}
					
				}	
				
				// two pair
				else if (ctwoPair == 1) {
					combo = card.findCombos(chand);
					Card[] combos = new Card[15];
					// gets combos
					for (int i = 0; i < combo.size(); i++) {
						combos[i] = combo.get(i);						
					}
					// swaps cards
					for (int j = 0; j < chand.length; j++) {
						if (combos[0] != chand[j]) {
							if (combos[1] != chand[j]) {
								if (combos[2] != chand[j]) {
									if (combos[3] != chand[j]) {
										card.hitPoker(chand, chand[j]);
									}
								} 
							}
						}
						else if (combos[1] != chand[j]) {
							if (combos[0] != chand[j]) {
								if (combos[2] != chand[j]) {
									if (combos[3] != chand[j]) {
										card.hitPoker(chand, chand[j]);
									}
								} 
							}
						}
						else if (combos[2] != chand[j]) {
							if (combos[0] != chand[j]) {
								if (combos[1] != chand[j]) {
									if (combos[3] != chand[j]) {
										card.hitPoker(chand, chand[j]);
									}
								} 
							}
						}
						else if (combos[3] != chand[j]) {
							if (combos[1] != chand[j]) {
								if (combos[2] != chand[j]) {
									if (combos[0] != chand[j]) {
										card.hitPoker(chand, chand[j]);
									}
								} 
							}
						}
					}
				}
			}
			
			// sets game data
			view.setGame("Dealers hit, \n" + chand[0].toString() + " " + chand[1].toString() + 
					" " + chand[2].toString() + " " + chand[3].toString() + " " + chand[4].toString());
			// reset counter to ZERO incase of new combo
			ctwoKind = 0;
			cthreeKind = 0;
			cfourKind = 0;
			ctwoPair = 0;
			cfullHouse = 0;
			cstraight = 0;
			dealerScore = 0;
			// check for combos and update dealer score again after taking a hit
			for (int j = 0; j < 1; j++) {
				dealerScore = 0;
				// two of a kind
				if (card.checkPairs(chand) == 1) {
					ctwoKind = 1;
					dealerScore = 1;
					dealersCombo = "Two of a kind.";
				}
				// two pairs
				else if (card.checkPairs(chand) == 2) {
					ctwoPair = 1;
					dealerScore = 2;
					dealersCombo = "Two pairs.";
				}
				// three of a kind
				else if (card.checkPairs(chand) == 6) {
					cthreeKind = 1;
					dealerScore = 3;
					dealersCombo = "Three of a kind.";
				}
				// four of a kind
				else if (card.checkPairs(chand) == 12) {
					cfourKind = 1;
					dealerScore = 6;
					dealersCombo = "Four of a kind.";
				}
				// full house
				else if (card.checkPairs(chand) == 4 || card.checkPairs(chand) == 8){
					cfullHouse = 1;
					dealerScore = 4;
					dealersCombo = "Full house.";
				}
				// straight 
				else if (card.straight(chand) == 1) {
					cstraight = 1;
					dealerScore = 5;
					dealersCombo = "Straight.";
				}
			}
			
			// prompt
			view.setMiddle("Two of a kind: " + twoKind +"\t" + "Dealer Two of a kind: " + ctwoKind +"\n"
					+ "Three of a kind: " + threeKind + "\t"+ "Dealer Three of a kind: " + cthreeKind + "\n"
					+ "Four of a kind: " + fourKind + "\t" + "Dealer Four of a kind: " + cfourKind + "\n"
				    + "Two Pair's: " + twoPair + "\t\t" + "Dealer Two Pair's: " + ctwoPair + "\n"
				    + "Straight: " + straight + "\t\t" + "Dealer Straight: " + cstraight + "\n"
				    + "Full House: " + fullHouse + "\t\t" + "Dealer Full House: " + cfullHouse);
			
			// save dealer card names for score updating
			cardNames[5] = card.saveCardName(chand[0]);
			cardNames[6] = card.saveCardName(chand[1]);
			cardNames[7] = card.saveCardName(chand[2]);
			cardNames[8] = card.saveCardName(chand[3]);
			cardNames[9] = card.saveCardName(chand[4]);
			
			// set players cards again
			view.setGame("\nPlayer's cards, \n" + cardNames[0] + " " + cardNames[1] + 
					" " + cardNames[2] + " " + cardNames[3] + " " + cardNames[4]);
			// set dealers cards again
			view.setGame("Dealer's cards,\n" + cardNames[5] + " " + cardNames[6] + 
					" " + cardNames[7] + " " + cardNames[8] + " " + cardNames[9]);
			// diable hit buttton 
			view.yes.setEnabled(false);
			view.no.setEnabled(false);
			
			// win conditions
			// if player wins
			if (playerScore > dealerScore) {
				JOptionPane.showMessageDialog(null, "Player wins with " + playersCombo);
				view.deal.setEnabled(true);
			}
			// if dealer wins
			else if (dealerScore > playerScore) {
				JOptionPane.showMessageDialog(null, "Dealer wins with " + dealersCombo);		
				view.deal.setEnabled(true);
			}
			// if scores are tied
			else {
				JOptionPane.showMessageDialog(null, "Both people had a " + dealersCombo + ". Push.");
				view.deal.setEnabled(true);
			}
		}
		
		/**
		 * EXIT BUTTON
		 * 
		 * closes game
		 * 
		 */
		
		if (event.getSource() == view.exit) {
			System.exit(0);
		}
	// catch non numbers.	
	} catch (NumberFormatException numE) {
		JOptionPane.showMessageDialog(null, "Please enter a number [0,1,2,3,4]");
	}
	}
}
