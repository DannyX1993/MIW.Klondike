package es.upm.miw.klondikedga;

import controller.Controller;
import controller.Logic;
import view.ConsoleView;
import view.MenuView;
import view.View;

public class Klondike {

	Logic logic;
	
	View view;
	
	public Klondike() {
		logic = new Logic();
		view = new ConsoleView();
	}
	
	public void play() {
		Controller controller;
		do {
			controller = logic.getController(new MenuView(logic.getBoard()).exploreMenu());
			if(controller != null) {
				view.interact(controller);
			}
		} while(controller != null);
	}
	
	public static void main(String[] args) {
		new Klondike().play();
	}
	
}
