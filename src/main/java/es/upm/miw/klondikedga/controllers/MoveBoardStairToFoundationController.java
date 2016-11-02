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

	public String validateMoveWhenIsFirstCardInFoundation(int origStair) {
		if(!getGame().isLastCardOfBoardStairAseOfSuit(origStair)) {
			return Error.getError(Error.ISNT_ACE);
		} else {
			getGame().moveFromBoardStairToFoundation(origStair);
		}
		return null;
	}

	public String validateMoveWhenIsntFirstCardInFoundation(int origStair) {
		if(!getGame().isOneNumGreaterOfFoundationLastCardFromBoardStair(origStair)) {
			String orig = getGame().getLastCardBoardStair(origStair).toString();
			String dest = getGame().getLastCardOfFoundationFromBoardStair(origStair).toString();
			return Error.getError(Error.PUT_ERROR, orig, dest);
		} else {
			getGame().moveFromBoardStairToFoundation(origStair);
		}
		return null;
	}

}
