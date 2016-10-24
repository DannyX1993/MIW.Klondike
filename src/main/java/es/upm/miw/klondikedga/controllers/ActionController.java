package es.upm.miw.klondikedga.controllers;

import es.upm.miw.klondikedga.models.Game;

public abstract class ActionController {
	
	private Game game;

	protected ActionController(Game game) {
		assert game != null;
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public boolean isBoardStairEmpty(int numBoardStair) {
		return getGame().isBoardStairEmpty(numBoardStair);
	}

	
	public abstract void accept(ControllerVisitor controllerVisitor);
	
}
