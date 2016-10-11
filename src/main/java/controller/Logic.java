package controller;

import java.util.ArrayList;

import model.Board;
import model.Game;

public class Logic {

	Game game;
	
	ArrayList<OptionController> controllers;
	
	public Logic() {
		assert game != null;
		game = new Game();
		initControllers();
	}
	
	private void initControllers() {
		controllers = new ArrayList<OptionController>();
		controllers.add(new MoveDeckToDiscardsController(game));
		controllers.add(new MoveDiscardsToDeckController(game));
		controllers.add(new MoveDiscardsToFoundationController(game));
		controllers.add(new MoveDiscardsToBoardStairController(game, new SubDialogController(game)));
		
		ArrayList<SubDialogController> subdialogControllers = new ArrayList<SubDialogController>(1);
		subdialogControllers.add(new SubDialogController(game));
		controllers.add(new MoveBoardStairToFoundationController(game, subdialogControllers));
		
		subdialogControllers = new ArrayList<SubDialogController>(3);
		subdialogControllers.add(new SubDialogController(game));
		subdialogControllers.add(new SubDialogController(game));
		subdialogControllers.add(new SubDialogController(game));
		controllers.add(new MoveBoardStairToBoardStairController(game, subdialogControllers));
		
		subdialogControllers = new ArrayList<SubDialogController>(1);
		subdialogControllers.add(new SubDialogController(game));
		controllers.add(new FlipLastCardOfBoardStairController(game, subdialogControllers));
	}
	
	public Board getBoard() {
		return game.getBoard();
	}
	
	public OptionController getController(int option) {
		assert option > 0;
		return controllers.get(option - 1);
	}
	
}
