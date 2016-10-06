package model;

import java.util.ArrayList;
import java.util.Stack;

public abstract class CardsStair {

	protected Stack<Card> cards;
	
	protected Suit suit;
	
	protected static final int MAX_CARDS = 13;
	
	public CardsStair() {
		cards = new Stack<Card>();
	}
	
	public CardsStair(ArrayList<Card> cards) {
		this.cards = new Stack<Card>();
		this.cards.addAll(cards);
	}
	
	public abstract boolean canAddCards(ArrayList<Card> cardsToAdd);
	// TODO -> PARTIR LA COMPROBACIÓN EN VARIAS FUNCIONES
	
	public void addCards(ArrayList<Card> cardsToAdd) {
		assert cardsToAdd != null;
		for(Card card : cardsToAdd) {
			cards.push(card);
		}
	}
	
	public void removeCard(int numCards) {
		assert numCards > 0 && canRemoveCards(numCards);
		for(int i = 0; i < numCards; i++) {
			cards.pop();
		}
	}
	
	private boolean canRemoveCards(int numCards) {
		return getNumCards() > numCards;
	}
	
	public ArrayList<Card> extractLastCards(int numCards) {
		assert numCards > 0;
		ArrayList<Card> cardsToExtract = new ArrayList<Card>(numCards);
		for(int i = 0; i < numCards; i++) {
			cardsToExtract.add(cards.pop());
		}
		
		return cardsToExtract;
	}
	
	public Card getLastCard() {
		return cards.peek();
	}
	
	public int getNumCards() {
		return cards.size();
	}
	
	public boolean isCompleted() {
		return getNumCards() == MAX_CARDS;
	}
	
	public abstract void print();
	
	
}
