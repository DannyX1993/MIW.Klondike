package es.upm.miw.klondikedga.controllers;

import es.upm.miw.klondikedga.models.Game;

public class MoveDiscardsToDeckController extends ActionController {

	protected MoveDiscardsToDeckController(Game game) {
		super(game);
	}


	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveDiscardsToDeck(this);
	}

}
