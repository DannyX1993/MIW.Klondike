package controller;

import model.Game;

public class MoveDiscardsToBoardStairController extends OptionController {

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
		controllerVisitor.visitMoveDiscardsToBoardStairController(this);
	}

}
