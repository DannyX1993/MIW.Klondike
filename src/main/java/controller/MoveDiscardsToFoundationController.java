package controller;

import model.Game;

public class MoveDiscardsToFoundationController extends OptionController {

	protected MoveDiscardsToFoundationController(Game game) {
		super(game);
	}
	
	
	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveDiscardsToFoundationCotroller(this);
	}

}
