package controller;

import model.Game;

public class MoveDeckToDiscardsController extends OptionController {

	protected MoveDeckToDiscardsController(Game game) {
		super(game);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveDeckToDiscardsController(this);
	}
	
}
