package es.upm.miw.klondikedga.controllers;

import es.upm.miw.klondikedga.models.Game;

public class MoveDiscardsToFoundationController extends ActionController {

	protected MoveDiscardsToFoundationController(Game game) {
		super(game);
	}
	
	
	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveDiscardsToFoundation(this);
	}

}
