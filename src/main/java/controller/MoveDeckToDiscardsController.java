package controller;

import model.Game;

public class MoveDeckToDiscardsController extends Controller {

	protected MoveDeckToDiscardsController(Game game) {
		super(game);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

	@Override
	public Error validateMove() {
		if(getGame().deckIsEmpty()) {
			return Error.DECK_EMPTY;
		}
		return null;
	}

}
