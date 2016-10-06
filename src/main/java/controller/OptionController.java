package controller;

import model.Game;

public abstract class OptionController {
	
	private Game game;

	protected OptionController(Game game) {
		assert game != null;
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	
	/*public abstract String validateMove();*/
	
	public abstract void accept(ControllerVisitor controllerVisitor);
	
}
