package es.upm.miw.klondikedga.controllers;

import es.upm.miw.klondikedga.models.Game;

public class MoveDiscardsToBoardStairController extends ActionController {

	SubDialogController subDialogController;
	
	protected MoveDiscardsToBoardStairController(Game game, SubDialogController subDialogController) {
		super(game);
		assert subDialogController != null;
		this.subDialogController = subDialogController;
	}

	public SubDialogController getSubDialogController() {
		return subDialogController;
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveDiscardsToBoardStair(this);
	}

}
