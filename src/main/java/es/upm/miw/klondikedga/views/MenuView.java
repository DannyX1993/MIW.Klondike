package es.upm.miw.klondikedga.views;

import es.upm.miw.klondikedga.controllers.MenuController;
import es.upm.miw.klondikedga.utils.IO;
import es.upm.miw.klondikedga.utils.LimitedIntDialog;

public class MenuView {
	
	MenuController menuController;
	
	private IO io = new IO();
	
	public MenuView(MenuController menuController) {
		this.menuController = menuController;
	}
	
	public int exploreMenu() {
		printBoard();
		return new LimitedIntDialog("Opción?", 9).read();
	}
	
	private void printBoard() {
		io.writeln("===========================");
		printDeck();
		printFoundation();
		printBoardStairs();
		io.writeln("---------------------------");
		printMenu();
	}
	
	private void printDeck() {
		io.write("Baraja: ");
		if(menuController.getBoardNumCardsInDeck() > 0) {
			io.writeln("[X,X]");
		} else {
			io.writeln("<vacío>");
		}
		io.write("Descarte: ");
		if(menuController.getBoardNumDiscards() > 0) {
			io.write(menuController.getStringDiscards());
			io.writeln();
		} else {
			io.writeln("<vacío>");
		}
	}
	
	private void printFoundation() {
		io.writeln(menuController.getStringFoundations());
	}
	
	private void printBoardStairs() {
		io.write(menuController.getStringBoardStairs());
	}
	
	private void printMenu() {
		io.write(menuController.getStringOptionsMenu());
	}
	
	
}
