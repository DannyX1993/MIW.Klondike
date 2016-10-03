package es.upm.miw.klondikedga;

public class BoardStair extends CardsStair {

	public BoardStair() {
		super();
	}
	
	public void addCard(Card card) {
		assert card != null;
		if(cards.size() == 0 && card.isKing()) { 
			super.addCard(card); 
		} else if(getLastCard().getSuit() != card.getSuit()  && card.isNumOneLess(getLastCard())) { 
			super.addCard(card);
		}
	}
	
}
