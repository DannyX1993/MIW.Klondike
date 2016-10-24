package es.upm.miw.klondikedga.controllers;

import java.util.ArrayList;

import es.upm.miw.klondikedga.models.Game;

public class MoveBoardStairToFoundationController extends ActionSubDialogController {
	
	protected MoveBoardStairToFoundationController(Game game, ArrayList<SubDialogController> subdialogControllers) {
		super(game, subdialogControllers);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveBoardStairToFoundation(this);
	}

}
