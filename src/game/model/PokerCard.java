package game.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PokerCard extends Card{
	
	Random rando = new Random();
	
	/**
	 * ----------POKER METHODS---------
	 */
	
	// overridden string method
	@Override
	public String toString() {
		// new string to return
		String newString = "";
		// string version of integer 'rank'
		String rank = String.valueOf(this.rank);
		// spades suit
		if (this.suit == 0) {
			// if rank is 10
			if (this.rank == 11) {
				newString = "Jack of Spades";
			}
			else if (this.rank == 12) {
				newString = "Queen of Spades";
			}
			else if (this.rank == 13) {
				newString = "King of Spades";	
			}
			// if rank is 11
			else if (this.rank == 1) {
				newString = "Ace of Spades";
			}
			// everything else
			else {
				newString = rank + " of Spades"; 
			}
		}
		// hearts suit
		else if (this.suit == 1) {
			// if rank is 10
			if (this.rank == 11) {
				newString = "Jack of Hearts";
			}
			else if (this.rank == 12) {
				newString = "Queen of Hearts";
			}
			else if (this.rank == 13){
				newString = "King of Hearts";
			}
			// if rank is 1
			else if (this.rank == 1) {
				newString = "Ace of Hearts";
			}
			// everything else
			else {
				newString = rank + " of Hearts"; 
			}
		}
		// clubs suit
		else if (this.suit == 2) {
			// if rank is 10
			if (this.rank == 11) {
					newString = "Jack of Clubs";
			}	
			else if (this.rank  == 12) {
				newString = "Queen of Clubs";
			}
			else if (this.rank == 13){
				newString = "King of Clubs";
			}
			// if rank is 1
				else if (this.rank == 1) {
				newString = "Ace of Clubs";
			}
			// everything else
			else {
				newString = rank + " of Clubs"; 
			}
		}
		// diamond suit
		else if (this.suit == 3) {
			// if rank is 10
			if (this.rank == 11) {
				newString = "Jack of Diamonds";
			}
			// if rank is 11
			else if (this.rank == 12) {
				newString = "Queen of Diamonds";
			}
			// if rank is 11
			else if (this.rank == 13) {
				newString = "King of Diamonds";
			}
			// if rank is 1
			else if (this.rank == 1) {
				newString = "Ace of Diamonds";
			}
			// everything else
			else {
				newString = rank + " of Diamonds"; 
			}
		}
		
		return newString;
	}
	
	// hit on poker
	public Card[] hitPoker(Card[] hand, Card card) {
		Card c = new Card();
		Card rcard = c.randomCard();
		int i = 0;
		for (i = 0; i < hand.length; i++) {
			if (hand[i].getSuit() == card.getSuit() && hand[i].getRank() == card.getRank()) {
				hand[i] = rcard;
				return hand;
			}
		}
		hand[i] = rcard;
		return hand;
	}
	
	// creates new Card array for poker, shouldn't be more then five 
	// cards I imagine
	public Card[] newHandPoker() {
		Card[] cards = new Card[5];
		return cards;
	}

	// checks for two of a kind, three of a kind and two pairs.
	// two of a kind = 1
	// two pairs = 2
	// three of a kind = 3
	public int checkPairs(Card[] hand) {
		int count = 0;
		int ranks[] = new int[5];
		for (int i = 0; i < 5; i++) {
			ranks[i] = hand[i].getRank();
		}
		// check each card against each other
		for (int j = 0; j < ranks.length; j++) {
			if (ranks[0] == ranks[j]) {
				count += 1;
			}
		}
		// minus one for counting itself
		count = count - 1;
		for (int m = 0; m < ranks.length; m++) {
			if (ranks[1] == ranks[m]) {
				count += 1;
			}
		}
		// minus one for counting itself
		count = count - 1;
		for (int m = 0; m < ranks.length; m++) {
			if (ranks[2] == ranks[m]) {
				count += 1;
			}
		}
		// minus one for counting itself
		count = count - 1;
		for (int m = 0; m < ranks.length; m++) {
			if (ranks[3] == ranks[m]) {
				count += 1;
			}
		}
		// minus one for counting itself
		count = count - 1;
		for (int m = 0; m < ranks.length; m++) {
			if (ranks[4] == ranks[m]) {
				count += 1;
			}
		}
		count = count - 1;
		// divide by two so numbers are easier to deal with
		if (count > 4) {
			return count;
		}
		else {
			int newCount = count / 2;
			// return newCount
			return newCount;
		}
		
	}
	
	// checks for two of a kind, three of a kind and two pairs.
		// two of a kind = 1
		// two pairs = 2
		// three of a kind = 6
		// four of a kind = 12
		// five of a kind = 20
		// full house = 4 || 8
		public ArrayList<Card> findCombos(Card[] hand) {
			// int[] for storing each card's rank
			int ranks[] = new int[5];
			// ArrayList for storing combos of cards
			ArrayList<Card> combos = new ArrayList<Card>();
			// loop for add ranks to array
			for (int i = 0; i < 5; i++) {
				ranks[i] = hand[i].getRank();
			}
			// adds pairs of cards to combos array
			// checks each card and adds it if it pairs with another
			for (int j = 0; j < ranks.length; j++) {
				if (j != 0) {
					if (ranks[0] == ranks[j]) {
						combos.add(hand[0]);
					}
				}
			}
			for (int m = 0; m < ranks.length; m++) {
				if (m != 1) {
					if (ranks[1] == ranks[m]) {
						combos.add(hand[1]);
					}
				}
			}
			for (int m = 0; m < ranks.length; m++) {
				if (m != 2) {
					if (ranks[2] == ranks[m]) {
						combos.add(hand[2]);
					}
				}
			}
			for (int m = 0; m < ranks.length; m++) {
				if (m != 3) {
					if (ranks[3] == ranks[m]) {
						combos.add(hand[3]);
					}
				}
			}
			for (int m = 0; m < ranks.length; m++) {
				if (m != 4) {
					if (ranks[4] == ranks[m]) {
						combos.add(hand[4]);
					}
				}
			}
			// return the ArrayList of combos
			return combos;
		}
		
	// checks for straight
	public int straight(Card[] hand) {
		// int[] to re-order card ranks in
		int[] ordered = new int[5];
		// counter used as a flag
		int count = 0;
		// add cards to be sorted
		for (int m = 0; m < hand.length; m++) {
			ordered[m] = hand[m].getRank();
		}
		// sort the cards
		Arrays.sort(ordered);
		// find differences between each card
		int two_one = ordered[1] - ordered[0];
		int three_two = ordered[2] - ordered[1];
		int four_three = ordered[3] - ordered[2];
		int five_four = ordered[4] - ordered[3];
		// flag for if it is true or not
		boolean isStraight = true;
		// for loop to chech each case
		for (int i = 0; i < 1; i++) {
			if (two_one != 1) {
				isStraight = false;
			}
			else if (three_two != 1) {
				isStraight = false;
			}
			else if (four_three != 1) {
				isStraight = false;
			}
			else if (five_four != 1) {
				isStraight = false;
			}
			// if all == 1
			else {
				isStraight = true;
			}
		}
		// if true count = 1
		if (isStraight == true) {
			count = 1;
		}
		// return count, I chose an int over boolean because it returns at the
		// same importance level as the rest. whereas boolean it would be returned first
		// and mess up the intended flow of events.
		return count;
	}
	
	
	// creates deck of cards
	public ArrayList<Card> newDeck(int numCards) {
		// new ArrayList to hold cards
		ArrayList<Card> deck = new ArrayList<Card>();
		// instance of card
		Card card = new Card();
		// counter
		int count = 0;
		// while loop to keep making cards until it == numCards
		while (count < numCards) {
			// nested loop for cycling through each card suit and rank
			// suits
			for (int i = 0; i < 4; i++) {
				// ranks
				for (int j = 1; j < 14; j++) {
					// new card with loop variables as suit and rank
					card = new Card(i, j);
					// add card to ArrayList
					deck.add(card);
					count += 1;
				}
			}
		}
		// return ArrayList
		return deck;
	}
	
	// gets a certain card but does not remove
	public Card getCard(ArrayList<Card> hand, int pick) {
		Card card = hand.get(pick);
		return card;
	}
		
	// deals cards 
	public ArrayList<Card> dealPoker(ArrayList<Card> deck, Card[] phand, Card[] chand) {
		PokerCard card = new PokerCard();
		// players hand
		for (int i = 0; i < 5; i++) {
			// random number between 0 and 51
			int rando = card.randomNumberRange(rand, 0, 51);
			Card card1 = card.getCard(deck, rando);
			phand[i] = card1;
			
			
		}
		// dealers hand
		for (int j = 0; j < 5; j++) {
			// random number between 0 and 51
			int rando = card.randomNumberRange(rand, 0, 51);
			Card card1 = card.getCard(deck, rando);
			chand[j] = card1;		
			
		}
		return deck;
	}
}
