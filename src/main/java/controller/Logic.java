package controller;

import java.util.ArrayList;

import model.Board;
import model.Game;

public class Logic {

	Game game;
	
	ArrayList<Controller> controllers;
	
	public Logic() {
		assert game != null;
		game = new Game();
		initControllers();
	}
	
	private void initControllers() {
		controllers = new ArrayList<Controller>();
		controllers.add(new MoveDeckToDiscardsController(game));
		controllers.add(new MoveDiscardsToDeckController(game));
	}
	
	public Board getBoard() {
		return game.getBoard();
	}
	
	/*public Game getGame() {
		return game;
	}*/
	
	public Controller getController(int option) {
		assert option > 0;
		return controllers.get(option - 1);
	}
	
}
