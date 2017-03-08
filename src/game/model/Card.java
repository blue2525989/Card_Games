package game.model;

import java.util.Random;

public class Card {

	// variables
	protected int rank;
	protected int suit;
	protected Random rand;
	
	// empty constructor
	public Card() {	}
	
	// constructor for new card
	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
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
			// if rank is 1
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
	
	// save name of string
	public String saveCardName(Card card) {
		String newString = card.toString();
		return newString;
	}
	
	// sets rank of card
	public int setRank(int rank) {
		this.rank = rank;
		return rank;
	}
	
	// gets rank of card
	public int getRank() {
		return this.rank;
	}
	
	// gets string version of rank
	public String getRankString(int r) {
		String rank = String.valueOf(r);
		return rank;
	}
	
	// sets suit of card
	public void setSuit(int suit) {
		this.suit = suit;
	}
	
	// gets suit of card
	public int getSuit() {
		return this.suit;
	}	

	// make special ace for times when you need an ace rank of 1
	public Card ace(Card org) {
		int orgs = org.getSuit();
		Card card = new Card(orgs, 1);
		return card;		
	}
	
	// makes random card
	public Card randomCard() {
		int randSuit = randomNumberRange(rand, 0, 4);
		int randRank = randomNumberRange(rand, 2, 12);		
		Card card = new Card(randSuit, randRank);
		return card;
	}
	
	// make a new card with specific suit/rank
	public Card newCard(int suit, int rank) {
		Card card = new Card(suit, rank);
		return card;
	}
	
	// remember to make high value one past what I want
	public int randomNumberRange(Random random, int low, int high) {
		int rando = (int)(high * Math.random()) + low;
		return rando;
	}

	// fills an array with one card at a time
	public Card[] addtoHand(Card[] deck, Card card) {
		for (int i = 0; i < deck.length; i++) {
			if (deck[i] == null) {
				deck[i] = card;
				return deck;
			}
		}
		return deck;
	}
	
	// returns a string version of hand
	public String getHand(Card[] deck) {
		String newString = "";
		Card card = new Card();
		int len = deck.length;
		for (int i = 0; i < len; i++) {
			if (deck[i] != null) {
				newString += " " + card.saveCardName(deck[i]);
			}
		}
		return newString;
	}

	// adds one card to hand
	public Card[] hit(Card[] hand) {
		Card card = new Card();
		// random card to use
		Card card1 = card.randomCard();
		// add card to hand in first non-null spot
		int i = 0;
		for (i = 0; i < hand.length; i++) {
			if (hand[i] == null) {
				hand[i] = card1;
				return hand;
			}
		}
		return hand;
	}
	
	// add to total
	public int addTotal(int rank) {
		int total = 0;
		total += rank;
		return total;
	}
	
	// gets total of hand
	public int getTotal(Card[] hand) {
		int total = 0;
		for (int i = 0; i < hand.length; i++) {
			if (hand[i] != null) {
				total += hand[i].getRank();
			}
		}
		return total;
	}
	
	// get last card added
	public Card getHit(Card[] hand) {
		for (int i = 0; i < hand.length; i++) {
			if (hand[i] == null) {
				return hand[i -1];
			}
		}
		return hand[2];
	}

	
}