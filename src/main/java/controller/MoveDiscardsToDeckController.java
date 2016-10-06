package controller;

import model.Game;

public class MoveDiscardsToDeckController extends Controller {

	protected MoveDiscardsToDeckController(Game game) {
		super(game);
	}

	@Override
	public Error validateMove() {
		if(!getGame().deckIsEmpty()) {
			return Error.DECK_WITH_CARDS;
		}
		return null;
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}