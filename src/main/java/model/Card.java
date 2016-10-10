package model;

import utils.ClosedInterval;

public class Card {
	
	private int num;
	
	private Suit suit;
	
	private boolean upturned;
	
	public Card(int num, Suit suit, boolean upturned) {
		this.setNum(num);
		this.setSuit(suit);
		this.setUpturned(upturned);
	}
	
	public void setNum(int num) {
		ClosedInterval closedInterval = new ClosedInterval(1, 13);
		assert closedInterval.isWithinRange(num);
		this.num = num;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public void setSuit(Suit suit) {
		assert suit != null;
		this.suit = suit;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public void setUpturned(boolean upturned) {
		this.upturned = upturned;
	}
	
	public boolean getUpturned() {
		return this.upturned;
	}
	
	public boolean isKing() {
		int numCardFromSymbol = SymbolsCard.KING.getNum();
		return num == numCardFromSymbol;
	}
	
	public boolean isQueen() {
		int numCardFromSymbol = SymbolsCard.QUEEN.getNum();
		return num == numCardFromSymbol;
	}
	
	public boolean isJack() {
		int numCardFromSymbol = SymbolsCard.JACK.getNum();
		return num == numCardFromSymbol;
	}
	
	public boolean isAce() {
		int numCardFromSymbol = SymbolsCard.ACE.getNum();
		return num == numCardFromSymbol;
	}
	
	public boolean isNumOneLess(Card card) {
		return (num + 1) == card.getNum();
	}
	
	public boolean isNumOneGreater(Card card) {
		return (num - 1) == card.getNum();
	}
	
	@Override
	public String toString() {
		String current = null;
		String ret = null;
		
		if(getUpturned()) {
			if(this.isAce()) current = "" + SymbolsCard.ACE.getSymbol();
			else if(this.isJack()) current = "" + SymbolsCard.JACK.getSymbol();
			else if(this.isQueen()) current = "" + SymbolsCard.QUEEN.getSymbol();
			else if(this.isKing()) current = "" + SymbolsCard.KING.getSymbol();
			
			ret = "[" + ((current != null) ? current : num) + "," + suit + "]";
		} else {
			ret = "[";
		}
		
		return ret;
	}
	
}
