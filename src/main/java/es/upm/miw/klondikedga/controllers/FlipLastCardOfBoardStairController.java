package es.upm.miw.klondikedga.controllers;

import java.util.ArrayList;

import es.upm.miw.klondikedga.models.Game;

public class FlipLastCardOfBoardStairController extends ActionSubDialogController {

	protected FlipLastCardOfBoardStairController(Game game, ArrayList<SubDialogController> subdialogControllers) {
		super(game, subdialogControllers);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitFlipLastCardOfBoardStair(this);
	}

	public String validateMoveWhenBoardIsntEmpty(int origStair) {
		if(getGame().getLastCardBoardStair(origStair).getUpturned()) {
			return Error.getError(Error.CANT_FLIP);
		} else {
			getGame().flipLastCardOfBoardStair(origStair);
		}
		return null;
	}

}
