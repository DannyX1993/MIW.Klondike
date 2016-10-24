package es.upm.miw.klondikedga.models;

import java.util.ArrayList;

public class BoardStair extends CardsStair {
	
	public BoardStair(ArrayList<Card> cards) {
		super(cards);
	}
	
	@Override
	public boolean canAddCards(ArrayList<Card> cardsToAdd) {
		assert cardsToAdd != null && cardsToAdd.size() > 0;
		
		for(Card card : cardsToAdd) {
			if(getNumCards() > 0) {
				Card lastCard = getLastCard();
				int newSize = getNumCards() + cardsToAdd.size();
				if(card.getSuit() != card.getSuit() && card.getNum() + 1 == lastCard.getNum() && newSize <= MAX_CARDS) {
					return true;
				} else {
					return false;
				}
			} else {
				if(!card.isKing()) {
					return false;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void print() {
		if(getNumCards() > 0) {
			for(Card card : cards) {
				System.out.print(card);
			}
			System.out.print("\n");
		} else {
			System.out.println("<vacío>");
		}
	}
	
	@Override
	public String toString() {
		String representation = "";
		if(getNumCards() > 0) {
			for(Card card : cards) {
				representation += card.toString();
			}
			representation += "\n";
		} else {
			representation = "<vacío>";
		}
		return representation;
	}
	
}
