package view;

import controller.Controller;
import controller.ControllerVisitor;
import controller.MoveDeckToDiscardsController;
import controller.MoveDiscardsToDeckController;
import controller.MoveDiscardsToFoundationController;
import controller.Error;
import utils.IO;

public class GameView implements ControllerVisitor {

	private IO io = new IO();
	
	public void interact(Controller controller) {
		controller.accept(this);
	}
	
	@Override
	public void visit(MoveDeckToDiscardsController moveDeckToWasteController) {
		Error error = moveDeckToWasteController.validateMove();
		if (error == null) {
			moveDeckToWasteController.getGame().moveFromDeckToDiscards();
		} else {
			io.writeln(error.toString());
		}
	}

	@Override
	public void visit(MoveDiscardsToDeckController moveDiscardsToDeckController) {
		Error error = moveDiscardsToDeckController.validateMove();
		if (error == null) {
			moveDiscardsToDeckController.getGame().moveFromDiscardsToDeck();
		} else {
			io.writeln(error.toString());
		}
	}

	@Override
	public void visit(MoveDiscardsToFoundationController moveDiscardsToFoundationController) {
		Error error = moveDiscardsToFoundationController.validateMove();
		if (error == null) {
			moveDiscardsToFoundationController.getGame().moveFromDiscardsToFoundation();
		} else {
			io.writeln(error.toString());
		}	
	}

}
