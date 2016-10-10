package controller;

import model.Game;

public class MoveDiscardsToDeckController extends OptionController {

	protected MoveDiscardsToDeckController(Game game) {
		super(game);
	}


	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveDiscardsToDeckController(this);
	}

}
