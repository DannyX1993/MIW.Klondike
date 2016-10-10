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

	public boolean isBoardStairEmpty(int numBoardStair) {
		return board.isBoardStairEmpty(numBoardStair);
	}

	public boolean areMoreCardsThanBoardStair(int numStair, int cardsNum) {
		return board.areMoreCardsThanBoardStair(numStair, cardsNum);
	}
	
	public boolean firstCardBoardStairOrigIsKing(int numBoardStair, int numCards) {
		return board.firstCardBoardStairOrigIsKing(numBoardStair, numCards);
	}
	
	public String getFirstNCardBoardStair(int numBoardStair, int cardsNum) {
		return board.getFirstNCardBoardStair(numBoardStair, cardsNum);
	}
	
	public String getLastCardBoardStair(int numBoardStair) {
		return board.getLastCardBoardStair(numBoardStair);
	}
	
	public boolean isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(int origStair, int numCards, int destStair) {
		return board.isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(origStair, numCards, destStair);
	}
	
	public boolean isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(int origStair, int numCards, int destStair) {
		return board.isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(origStair, numCards, destStair);
	}
	
	

	public void moveFromBoardStairToBoardStair(int origStair, int destStair, int numCards) {
		board.moveFromBoardStairToBoardStair(origStair, destStair, numCards);
	}
}
