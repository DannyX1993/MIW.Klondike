package es.upm.miw.klondikedga.models;

public enum Suit {
	COINS(0, 'o', "oros"),
	CUPS(1, 'c', "copas"),
	SWORDS(2, 'e', "espadas"),
	BASTOS(3, 'b', "bastos");
	
	public static final int NUM_SUITS = 4;
	
	private int pos;
	
	private char value;
	
	private String suitText;
	
	private Suit(int pos, char value, String suitText) {
		this.pos = pos;
		this.value = value;
		this.suitText = suitText;
	}
	
	public int getPos() {
		return pos;
	}
	
	public String getSuitText() {
		return suitText;
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
}
