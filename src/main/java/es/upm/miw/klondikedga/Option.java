package es.upm.miw.klondikedga;

public enum Option {
	MOVE_FROM_DECK_TO_WASTE(1, "Mover de baraja a descarte"),
	MOVE_FROM_WASTE_TO_DECK(2, "Mover de descarte a baraja"),
	MOVE_FROM_WASTE_TO_FOUNDATION(3, "Mover de descarte a palo"),
	MOVE_FROM_WASTE_TO_BOARDSTAIR(4, "Mover de descarte a escalera"),
	MOVE_FROM_BOARDSTAIR_TO_FOUNDATION(5, "Mover de escalera a palo"),
	MOVE_FROM_BOARDSTAIR_TO_BOARDSTAIR(6, "Mover de escalera a escalera"),
	MOVE_FROM_FOUNDATION_TO_BOARDSTAIR(7, "Mover de palo a escalera"),
	BOARDSTAIR_FLIP(8, "Voltear en escalera"),
	EXIT(9, "Salir");
	
	private int num;
	
	private String text;
	
	private Option(int num, String text) {
		this.num = num;
		this.text = text;
	}
	
	public int getNum() {
		return num;
	}
	
	public String getText() {
		return text;
	}
}
