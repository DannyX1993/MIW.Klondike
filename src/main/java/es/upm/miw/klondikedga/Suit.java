package es.upm.miw.klondikedga;

public enum Suit {
	SWORDS('e'),
	COINS('o'),
	CUPS('c'),
	BASTOS('b');
	
	public static final int NUM_SUITS = 4;
	
	private char value;
	
	private Suit(char value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
}
