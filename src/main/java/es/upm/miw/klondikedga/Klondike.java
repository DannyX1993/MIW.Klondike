package es.upm.miw.klondikedga;

import es.upm.miw.klondikedga.controllers.Logic;
import es.upm.miw.klondikedga.controllers.ActionController;
import es.upm.miw.klondikedga.views.ConsoleView;
import es.upm.miw.klondikedga.views.View;

public class Klondike {

	Logic logic;
	
	View view;
	
	public Klondike() {
		logic = new Logic();
		view = new ConsoleView();
	}
	
	public void play() {
		ActionController controller;
		do {
			int optionSelected = view.interactWithMenu(logic.getMenuController());
			controller = logic.getActionController(optionSelected);
			if(controller != null) {
				view.interact(controller);
			}
			if(logic.isTheEndOfGame()) {
				view.showTheEndOfGameMessage();
				controller = null;
			}
		} while(controller != null);
	}
	
	public static void main(String[] args) {
		new Klondike().play();
	}
	
}
