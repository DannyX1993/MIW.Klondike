package controller;

import model.Game;

public abstract class Controller {
	
	private Game game;

	protected Controller(Game game) {
		assert game != null;
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	
	public abstract Error validateMove();
	public abstract void accept(ControllerVisitor controllerVisitor);
	
}
