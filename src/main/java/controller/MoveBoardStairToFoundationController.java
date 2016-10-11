package controller;

import java.util.ArrayList;

import model.Game;

public class MoveBoardStairToFoundationController extends OptionSubDialogController {

	private ArrayList<SubDialogController> subdialogControllers;
	
	protected MoveBoardStairToFoundationController(Game game, ArrayList<SubDialogController> subdialogControllers) {
		super(game, subdialogControllers);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveBoardStairToFoundation(this);
	}

}
