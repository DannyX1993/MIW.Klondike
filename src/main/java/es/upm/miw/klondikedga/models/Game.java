package es.upm.miw.klondikedga.models;

public class Game {

	private Menu menu;
	
	private Board board;
	
	public Game() {
		board = new Board();
		menu = new Menu();
	}
	
	public Menu getMenu() {
		return menu;
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
	
	public boolean isFirstCardToInsertInFoundationFromDiscards() {
		return board.isFirstCardToInsertInFoundationFromDiscards();
	}
	
	public boolean isFirstCardToInsertInFoundationFromBoardStair(int numBoardStair) {
		return board.isFirstCardToInsertInFoundationFromBoardStair(numBoardStair);
	}
	
	public boolean isOneNumGreaterOfFoundationLastCardFromDiscard() {
		return board.isOneNumGreaterOfFoundationLastCard();
	}
	
	public boolean isOneNumGreaterOfFoundationLastCardFromBoardStair(int numBoardStair) {
		return board.isOneNumGreaterOfFoundationLastCardFromBoardStair(numBoardStair);
	}
	
	public boolean isLastDiscardAseOfSuit() {
		return board.isLastDiscardAceOfSuit();
	}
	
	public boolean isLastCardOfBoardStairAseOfSuit(int numBoardStair) {
		return board.isLastCardOfBoardStairAseOfSuit(numBoardStair);
	}
	
	public boolean canMoveDiscardToFoundation() {
		return board.canMoveDiscardToFoundation();
	}
	
	public Card getLastDiscard() {
		return board.getLastDiscard();
	}
	
	public Card getLastCardOfFoundationFromDiscards() {
		return board.getLastCardOfFoundationFromDiscards();
	}
	
	public Card getLastCardOfFoundationFromBoardStair(int numBoardStair) {
		return board.getLastCardOfFoundationFromBoardStair(numBoardStair);
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
	
	public void moveFromBoardStairToFoundation(int numBoardStair) {
		board.moveFromBoardStairToFoundation(numBoardStair);
	}
	
	public void flipLastCardOfBoardStair(int numBoardStair) {
		board.flipLastCardOfBoardStair(numBoardStair);
	}
	
	public boolean isFirstCardToInsertInBoardStair(int numBoardStair) {
		return board.isFirstCardToInsertInBoardStair(numBoardStair);
	}
	
	public boolean lastDiscardIsKing() {
		return board.lastDiscardIsKing();
	}
	
	public boolean lastFoundationCardIsKing(int numFoundation) {
		return board.lastFoundationCardIsKing(numFoundation);
	}
	
	public boolean lastFoundationIsOneNumLessThanLastCardBoardStair(int numFoundation, int numStair) {
		return board.lastFoundationIsOneNumLessThanLastCardBoardStair(numFoundation, numStair);
	}
	
	public boolean lastCardOfBoardStairIsSameSuitThanLastDiscard(int numBoardStair) {
		return board.lastCardOfBoardStairIsSameSuitThanLastDiscard(numBoardStair);
	}
	
	public boolean lastCardOfBoardStairIsSameSuitThanLastFoundationCard(int numFoundation, int numStair) {
		return board.lastCardOfBoardStairIsSameSuitThanLastFoundationCard(numFoundation, numStair);
	}
	
	public boolean lastDiscardIsOneNumLessThanLastCardBoardStair(int numBoardStair) {
		return board.lastDiscardIsOneNumLessThanLastCardBoardStair(numBoardStair);
	}
	
	public Card getLastCardBoardStair(int numBoardStair) {
		return board.getLastCardOfBoardStair(numBoardStair);
	}
	
	public void moveFromDiscardsToBoardStair(int numBoardStair) {
		board.moveFromDiscardsToBoardStair(numBoardStair);
	}

	public boolean isFoundationEmpty(int numFoundation) {
		return board.isFoundationEmpty(numFoundation);
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
	
	public String getLastCardBoardStairString(int numBoardStair) {
		return board.getLastCardBoardStairString(numBoardStair);
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

	public String getStringLastCardBoardStair(int destFoundation) {
		return board.getLastCardBoardStairString(destFoundation);
	}

	public void moveFromFoundationToBoardStair(int numFoundation, int destStair) {
		board.moveFromFoundationToBoardStair(numFoundation, destStair);
	}

	public boolean isTheEndOfGame() {
		boolean completed = true;
		for(CardsStair stair : board.getFoundations()) {
			if(stair.getNumCards() < CardsStair.MAX_CARDS) {
				completed = false;
				break;
			}
		}
		return completed;
	}
}
