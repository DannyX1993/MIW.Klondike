package controller;

public enum Error {

	DECK_EMPTY("ERROR!!! La baraja está vacía"),
	DECK_WITH_CARDS("ERROR!!! La baraja aun tiene cartas");
	
	private String message;
	
	private Error(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}
}
