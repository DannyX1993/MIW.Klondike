package es.upm.miw.klondikedga;

import java.util.ArrayList;

public abstract class CardsStair {

	ArrayList<Card> cards;
	
	private static final int MAX_CARDS = 13;
	
	public CardsStair() {
		cards = new ArrayList<Card>(MAX_CARDS);
	}
	
	public void addCard(Card card) {
		assert card != null;
		assert getNumCards() < MAX_CARDS;
		cards.add(card);
	}
	
	public void removeCard(Card card) {
		cards.remove(card);
	}
	
	public void removeCardPos(int pos) {
		assert pos >= 0 && pos < getNumCards();
		cards.remove(pos);
	}
	
	public Card getLastCard() {
		return cards.get(getNumCards() - 1);
	}
	
	public int getLastCardPos() {
		int numCards = getNumCards();
		int size = (numCards > 0) ? numCards : 0;
		return size;
	}
	
	public int getNumCards() {
		return cards.size();
	}
	
}
