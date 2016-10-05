package es.upm.miw.klondikedga;

public class Klondike {

	Board board;
	
	public Klondike() {
		board = new Board();
	}
	
	public void play() {
		board.print();
	}
	
	public static void main(String[] args) {
		new Klondike().play();
	}
	
}
