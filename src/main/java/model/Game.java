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
	
	public boolean discardsIsEmpty() {
		return board.getNumCardsDiscards() == 0;
	}
	
	public boolean isFirstCardToInsertInFoundation() {
		return board.isFirstCardToInsertInFoundation();
	}
	
	public boolean isOneNumGreaterOfFoundationLastCard() {
		return board.isOneNumGreaterOfFoundationLastCard();
	}
	
	public boolean isLastDiscardAseOfSuit() {
		return board.isLastDiscardAceOfSuit();
	}
	
	public boolean canMoveDiscardToFoundation() {
		return board.canMoveDiscardToFoundation();
	}
	
	public Card getLastDiscard() {
		return board.getLastDiscard();
	}
	
	public Card getLastCardOfFoundation() {
		return board.getLastCardOfFoundation();
	}
	
	public void moveFromDeckToDiscards() {
		board.moveFromDeckToDiscards();
	}
	
	public void moveFromDiscardsToDeck() {
		board.moveFromDiscardsToDeck();
	}
	
	public void moveFromDiscardsToFoundation() {
		board.moveFromDiscardsToFoundation();
	}
	
	public boolean isFirstCardToInsertInBoardStair(int numBoardStair) {
		return board.isFirstCardToInsertInBoardStair(numBoardStair);
	}
	
	public boolean lastDiscardIsKing() {
		return board.lastDiscardIsKing();
	}
	
	public boolean lastCardOfBoardStairIsSameSuit(int numBoardStair) {
		return board.lastCardOfBoardStairIsSameSuit(numBoardStair);
	}
	
	public boolean isOneNumLessThanLastCardBoardStair(int numBoardStair) {
		return board.isOneNumLessThanLastCardBoardStair(numBoardStair);
	}
	
	public Card getLastCardOfBoardStair(int numBoardStair) {
		return board.getLastCardOfBoardStair(numBoardStair);
	}
	
	public void moveFromDiscardsToBoardStair(int numBoardStair) {
		board.moveFromDiscardsToBoardStair(numBoardStair);
	}
}
