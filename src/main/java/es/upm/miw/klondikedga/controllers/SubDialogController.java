package es.upm.miw.klondikedga.controllers;

import es.upm.miw.klondikedga.models.Game;

public class SubDialogController {

	private Game game;
	
	protected SubDialogController(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public String getStringLastDiscard() {
		return getGame().getLastDiscard().toString();
	}

	public String getStringLastCardBoardStair(int destStair) {
		return getGame().getLastCardBoardStairString(destStair).toString();
	}
	
	public boolean isFirstCardToInsertInBoardStair(int destStair) {
		return getGame().isFirstCardToInsertInBoardStair(destStair);
	}
	
	public boolean lastDiscardIsKing() {
		return getGame().lastDiscardIsKing();
	}
	
	public boolean lastCardOfBoardStairIsSameSuit(int destStair) {
		return getGame().lastCardOfBoardStairIsSameSuit(destStair);
	}
	
	public boolean isOneNumLessThanLastCardBoardStair(int destStair) {
		return getGame().isOneNumLessThanLastCardBoardStair(destStair);
	}
	
}
