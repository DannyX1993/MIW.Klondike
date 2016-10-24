package es.upm.miw.klondikedga.models;

import es.upm.miw.klondikedga.utils.ClosedInterval;

public enum SymbolsCard {
	
	ACE('A', 1),
	JACK('J', 11),
	QUEEN('Q', 12),
	KING('K', 13);
	
	private char symbol;
	
	private int num;
	
	private SymbolsCard(char symbol, int num) {
		ClosedInterval closedInterval = new ClosedInterval(1, 13);
		assert closedInterval.isWithinRange(num);
		this.symbol = symbol;
		this.num = num;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public int getNum() {
		return this.num;
	}
}
