package game.model;

public class BlackJackCard extends Card{

	/**
	 * Black Jack methods
	 */
	
	
	// overridden string method to print card names
	// works well for black jack but not so much poker
	@Override
	public String toString() {
		// new string to return
		String newString = "";
		// string version of integer 'rank'
		String rank = String.valueOf(this.rank);
		// random number to pick between Jack, Queen, King
		int rando = randomNumberRange(rand, 0, 3);
		// spades suit
		if (this.suit == 0) {
			// if rank is 10
			if (this.rank == 10) {
				if (rando == 0) {
					newString = "Jack of Spades";
				}
				else if (rando == 1) {
					newString = "Queen of Spades";
				}
				else if (rando == 2) {
					newString = "King of Spades";
				}
			}
			// if rank is 11
			else if (this.rank == 11) {
				newString = "Ace of Spades";
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
			if (this.rank == 10) {
				if (rando == 0) {
					newString = "Jack of Hearts";
				}
				else if (rando == 1) {
					newString = "Queen of Hearts";
				}
				else {
					newString = "King of Hearts";
				}
			}
			// if rank is 11
			else if (this.rank == 11) {
				newString = "Ace of Hearts";
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
			if (this.rank == 10) {
				if (rando == 0) {
					newString = "Jack of Clubs";
				}
				else if (rando == 1) {
					newString = "Queen of Clubs";
				}
				else {
					newString = "King of Clubs";
				}
			}
			// if rank is 11
			else if (this.rank == 11) {
				newString = "Ace of Clubs";
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
			if (this.rank == 10) {
				if (rando == 0) {
					newString = "Jack of Diamonds";
				}
				else if (rando == 1) {
					newString = "Queen of Diamonds";
				}
				else {
					newString = "King of Diamonds";
				}
			}
			// if rank is 11
			else if (this.rank == 11) {
				newString = "Ace of Diamonds";
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
	
	// deals two cards for black jack
	public void deal(Card[] hand1, Card[] hand2) {
		Card card = new Card();
		// random cards to use
		Card card1 = card.randomCard();
		Card card2 = card.randomCard();
		Card ace = card.ace(card2);
		Card card3 = card.randomCard();
		Card card4 = card.randomCard();		
		Card ace2 = card.ace(card4);
		// if dealt two aces on first hand, change the second
		// one to value of 1
		// player hand
		hand1[0] = card1;
		// dealer hand
		hand2[0] = card3;
		// players hand
		if (card1.getRank() == 11 && card2.getRank() == 11) {
			hand1[1] = ace;
			hand2[1] = card4;
			if (card3.getRank() == 11 && card4.getRank() == 11) {
				hand2[1] = ace2;
			}
		}
		else if (card1.getRank() != 11 && card2.getRank() != 11){
			hand1[1] = card2;
			hand2[1] = card4;
		}
		// dealers hand
		else if (card3.getRank() == 11 && card4.getRank() == 11) {
			hand2[1] = ace2;
			hand1[1] = card2;
		}
		else{
			hand1[1] = card2;
			hand2[1] = card4;
		}
	}
	
	
	// creates new Card array for black jack
	public Card[] newHand() {
		Card[] cards = new Card[11];
		return cards;
	}
	
	
	// checks to see if busted or not
	public boolean isBusted(Card[] hand) {
		Card card = new Card();
		int total = card.getTotal(hand);
		if (total > 21) {
			return true;
		}
		return false;
	}
	
	// to see if blackjack or not
	public boolean isBlackjack(Card[] hand) {
		Card card = new Card();
		if (card.getTotal(hand) == 21) {
			return true;
		}
		return false;
	}
}
