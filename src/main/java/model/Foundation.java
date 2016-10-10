package model;

import java.util.ArrayList;

public class Foundation extends CardsStair {
	
	protected static final int MAX_CARDS = 13;
	
	public Foundation(Suit suit) {
		super();
		assert suit != null;
		this.suit = suit;
	}

	@Override
	public boolean canAddCards(ArrayList<Card> cardsToAdd) {
		assert cardsToAdd != null;
		assert cardsToAdd.size() > 0;
		for(Card card : cardsToAdd) {
			if(getNumCards() > 0) {
				Card lastCard = getLastCard();
				if(lastCard.getSuit() == card.getSuit() && lastCard.getNum() + 1 == card.getNum()) {
					return true;
				} else {
					return false;
				}
			} else {
				if(card.getSuit() == suit && card.isAce()) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String representation = "Palo " + suit.getSuitText() + ": ";
		if(getNumCards() > 0) {
			for(Card card : cards) {
				representation += card.toString();
			}
		} else {
			representation += "<vacío>";
		}
		return representation;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	
}
