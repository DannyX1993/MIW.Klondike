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

	public String validateMoveWhenIsntBoardStairEmpty(int destStair) {
		String orig = subDialogController.getStringLastDiscard();
		String dest = subDialogController.getStringLastCardBoardStair(destStair);
		if(subDialogController.isFirstCardToInsertInBoardStair(destStair) && !subDialogController.lastDiscardIsKing()){
			return Error.getError(Error.ISNT_KING);
		} else if(subDialogController.lastCardOfBoardStairIsSameSuit(destStair) || !subDialogController.isOneNumLessThanLastCardBoardStair(destStair)) {
			return Error.getError(Error.PUT_ERROR, orig, dest);
		} else {
			getGame().moveFromDiscardsToBoardStair(destStair);
		}
		return null;
	}

	public String validateMoveWhenIsBoardStairEmpty(int destStair) {
		String orig = subDialogController.getStringLastDiscard();
		String dest = subDialogController.getStringLastCardBoardStair(destStair);
		if(!subDialogController.lastDiscardIsKing()) {
			return Error.getError(Error.PUT_ERROR, orig, dest);
		} else {
			getGame().moveFromDiscardsToBoardStair(destStair);
		}
		return null;
	}

}
