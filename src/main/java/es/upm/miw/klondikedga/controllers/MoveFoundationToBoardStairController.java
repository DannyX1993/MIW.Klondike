package es.upm.miw.klondikedga.controllers;

import java.util.ArrayList;

import es.upm.miw.klondikedga.models.Game;

public class MoveFoundationToBoardStairController extends ActionSubDialogController {


	protected MoveFoundationToBoardStairController(Game game, ArrayList<SubDialogController> subdialogControllers) {
		super(game, subdialogControllers);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveFoundationToBoardStair(this);
	}

	public String getStringFirstCardFoundation(int origFoundation) {
		return getGame().getBoard().getFoundations().get(origFoundation - 1).getLastCard().toString();
	}

	public boolean isFoundationEmpty(int origFoundation) {
		return getGame().isFoundationEmpty(origFoundation);
	}

	public String getLastCardFoundation(int destFoundation) {
		return getGame().getStringLastCardOfFoundation(destFoundation);
	}

}
