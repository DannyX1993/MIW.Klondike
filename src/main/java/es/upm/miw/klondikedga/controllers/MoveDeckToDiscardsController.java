package es.upm.miw.klondikedga.controllers;

import es.upm.miw.klondikedga.models.Game;

public class MoveDeckToDiscardsController extends ActionController {

	protected MoveDeckToDiscardsController(Game game) {
		super(game);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveDeckToDiscards(this);
	}
	
}
