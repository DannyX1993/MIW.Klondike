package es.upm.miw.klondikedga.controllers;

import java.util.ArrayList;

import es.upm.miw.klondikedga.models.Board;
import es.upm.miw.klondikedga.models.Game;

public class Logic {

	Game game;
	
	MenuController menuController;
	ArrayList<ActionController> actionsControllers;
	
	public Logic() {
		assert game != null;
		game = new Game();
		initMenuController();
		initActionControllers();
	}
	
	public Game getGame() {
		return game;
	}
	
	public Board getBoard() {
		return game.getBoard();
	}
	
	private void initMenuController() {
		this.menuController = new MenuController(game);
	}
	
	public boolean isTheEndOfGame() {
		return game.isTheEndOfGame();
	}
	
	public MenuController getMenuController() {
		return this.menuController;
	}
	
	private void initActionControllers() {
		actionsControllers = new ArrayList<>();
		actionsControllers.add(new MoveDeckToDiscardsController(game));
		actionsControllers.add(new MoveDiscardsToDeckController(game));
		actionsControllers.add(new MoveDiscardsToFoundationController(game));
		actionsControllers.add(new MoveDiscardsToBoardStairController(game, new SubDialogController(game)));
		
		ArrayList<SubDialogController> subdialogControllers = new ArrayList<SubDialogController>(1);
		subdialogControllers.add(new SubDialogController(game));
		actionsControllers.add(new MoveBoardStairToFoundationController(game, subdialogControllers));
		
		subdialogControllers = new ArrayList<>(3);
		subdialogControllers.add(new SubDialogController(game));
		subdialogControllers.add(new SubDialogController(game));
		subdialogControllers.add(new SubDialogController(game));
		actionsControllers.add(new MoveBoardStairToBoardStairController(game, subdialogControllers));
		
		subdialogControllers = new ArrayList<>(2);
		subdialogControllers.add(new SubDialogController(game));
		subdialogControllers.add(new SubDialogController(game));
		actionsControllers.add(new MoveFoundationToBoardStairController(game, subdialogControllers));
		
		subdialogControllers = new ArrayList<>(1);
		subdialogControllers.add(new SubDialogController(game));
		actionsControllers.add(new FlipLastCardOfBoardStairController(game, subdialogControllers));
	}
	
	public ActionController getActionController(int option) {
		assert option > 0;
		if(option == 9) {
			System.exit(0);
		}
		return actionsControllers.get(option - 1);
	}
	
}
