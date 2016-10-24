package es.upm.miw.klondikedga.controllers;

import java.util.ArrayList;

import es.upm.miw.klondikedga.models.Game;

public abstract class ActionSubDialogController extends ActionController {

	private ArrayList<SubDialogController> subdialogControllers;
	
	protected ActionSubDialogController(Game game, ArrayList<SubDialogController> subdialogControllers) {
		super(game);
		assert subdialogControllers != null;
		this.subdialogControllers = subdialogControllers;
	}
	
	public ArrayList<SubDialogController> getSubDialogControllers() {
		return subdialogControllers;
	}

}
