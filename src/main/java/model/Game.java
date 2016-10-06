package model;

public class Game {

	private Board board;
	
	public Game() {
		board = new Board();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public boolean deckIsEmpty() {
		return board.getNumCardsDeck() == 0;
	}
	
	public boolean canMoveDiscardToFoundation() {
		return board.canMoveDiscardToFoundation();
	}
	
	public void moveFromDeckToDiscards() {
		board.moveFromDeckToDiscards();
	}
	
	public void moveFromDiscardsToDeck(){
		board.moveFromDiscardsToDeck();
	}
	
	public void moveFromDiscardsToFoundation(){
		board.moveFromDiscardsToFoundation();
	}
}
