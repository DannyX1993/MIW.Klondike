package controller;

import model.Game;

public class SubDialogController {

	private Game game;
	
	protected SubDialogController(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}

}
