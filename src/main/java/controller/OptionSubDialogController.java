package controller;

import java.util.ArrayList;

import model.Game;

public abstract class OptionSubDialogController extends OptionController {

	private ArrayList<SubDialogController> subdialogControllers;
	
	protected OptionSubDialogController(Game game, ArrayList<SubDialogController> subdialogControllers) {
		super(game);
		assert subdialogControllers != null;
		this.subdialogControllers = subdialogControllers;
	}
	
	public ArrayList<SubDialogController> getSubDialogControllers() {
		return subdialogControllers;
	}

}
