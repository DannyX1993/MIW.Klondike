package es.upm.miw.klondikedga;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> cards;
	
	private static final int TOTAL_CARDS = 52;
	
	public static final int CARDS_PER_SUIT = TOTAL_CARDS / Suit.NUM_SUITS;
	
	public Deck() {
		cards = new ArrayList<Card>(TOTAL_CARDS);
		setCardsOfSuit(Suit.COINS);
		setCardsOfSuit(Suit.SWORDS);
		setCardsOfSuit(Suit.BASTOS);
		setCardsOfSuit(Suit.CUPS);
	}
	
	private void setCardsOfSuit(Suit suit) {
		assert suit != null;
		for(int i = 1; i <= CARDS_PER_SUIT; i++) {
			cards.add(new Card(i, suit, false));
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public int getNumCards() {
		return cards.size();
	}
	
	public int getCardsPerSuit() {
		return CARDS_PER_SUIT;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
}
