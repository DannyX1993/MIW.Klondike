package es.upm.miw.klondikedga;

public class Foundation extends CardsStair {

	private Suit suit;
	
	public Foundation(Suit suit) {
		super();
		assert suit != null;
		this.suit = suit;
	}
	
	public void addCard(Card card) {
		assert card != null;
		if(cards.size() == 0 && suit == card.getSuit()) { 
			super.addCard(card); 
		} else if(suit == card.getSuit()  && card.isNumOneGreater(getLastCard())) { 
			super.addCard(card);
		}
	}
	
	
}
