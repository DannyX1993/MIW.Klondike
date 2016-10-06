package view;

import model.Board;
import model.Card;
import model.CardsStair;
import model.Option;
import utils.IO;
import utils.LimitedIntDialog;

public class MenuView {

	private Board board;
	
	private IO io = new IO();
	
	public MenuView(Board board) {
		this.board = board;
	}
	
	
	public int exploreMenu() {
		printBoard();
		int option = new LimitedIntDialog("Opción?", 9).read();
		return option;
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
		if(board.getNumCardsDeck() > 0) {
			io.writeln("[X,X]");
		} else {
			io.writeln("<vacío>");
		}
		io.write("Descarte: ");
		if(board.getNumCardsDiscards() > 0) {
			for(Card card : board.getDiscards()) {
				io.write(card.toString());
			}
			io.writeln();
		} else {
			io.writeln("<vacío>");
		}
	}
	
	private void printFoundation() {
		for(CardsStair cStair : board.getFoundations()) {
			io.writeln(cStair.toString());
		}
	}
	
	private void printBoardStairs() {
		int i = 0;
		for(CardsStair cStair : board.getBoardStairs()) {
			io.write("Escalera " + (i + 1) + ": ");
			io.write(cStair.toString());
			i++;
		}
	}
	
	private void printMenu() {
		int i = 1;
		for(Option option: Option.values()) {
			io.writeln(i + ". " + option.getText());
			i++;
		}
	}
	
	
}
