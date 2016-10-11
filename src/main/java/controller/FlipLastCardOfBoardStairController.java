package controller;

import java.util.ArrayList;

import model.Game;

public class FlipLastCardOfBoardStairController extends OptionSubDialogController {

	protected FlipLastCardOfBoardStairController(Game game, ArrayList<SubDialogController> subdialogControllers) {
		super(game, subdialogControllers);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitFlipLastCardOfBoardStair(this);
	}

}
