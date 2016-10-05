package es.upm.miw.klondikedga;

public enum Suit {
	SWORDS('e', "espadas"),
	COINS('o', "oros"),
	CUPS('c', "copas"),
	BASTOS('b', "bastos");
	
	public static final int NUM_SUITS = 4;
	
	private char value;
	
	private String suitText;
	
	private Suit(char value, String suitText) {
		this.value = value;
		this.suitText = suitText;
	}
	
	public String getSuitText() {
		return suitText;
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
}
