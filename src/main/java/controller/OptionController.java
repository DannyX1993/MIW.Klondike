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
	
	public boolean isBoardStairEmpty(int numBoardStair) {
		return getGame().isBoardStairEmpty(numBoardStair);
	}

	
	public abstract void accept(ControllerVisitor controllerVisitor);
	
}
