package es.upm.miw.klondikedga;

import java.util.ArrayList;

public class Foundation extends CardsStair {
	
	private Suit suit;
	
	protected static final int MAX_CARDS = 13;
	
	public Foundation(Suit suit) {
		super();
		assert suit != null;
		this.suit = suit;
	}

	@Override
	public boolean canAddCards(ArrayList<Card> cardsToAdd) {
		assert cardsToAdd != null && cardsToAdd.size() > 0;
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
	public void print() {
		System.out.print("Palo " + suit.getSuitText() + ": ");
		if(getNumCards() > 0) {
			for(Card card : cards) {
				System.out.print(card);
			}
			System.out.print("\n");
		} else {
			System.out.println("<vacío>");
		}
	}
	
	
}
