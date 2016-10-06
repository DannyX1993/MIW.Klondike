package controller;

import java.util.ArrayList;

import model.Game;

public class MoveBoardStairToBoardStairController extends OptionController {

	private ArrayList<SubDialogController> subdialogControllers;
	
	protected MoveBoardStairToBoardStairController(Game game, ArrayList<SubDialogController> subdialogControllers) {
		super(game);
		assert subdialogControllers != null;
		this.subdialogControllers = subdialogControllers;
	}
	
	public ArrayList<SubDialogController> getSubDialogControllers() {
		return subdialogControllers;
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
