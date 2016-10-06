package view;

import controller.Controller;
import controller.MoveDeckToDiscardsController;
import controller.MoveDiscardsToDeckController;
import controller.MoveDiscardsToFoundationController;

public class ConsoleView implements View {
	
	private GameView gameView;
	
	public ConsoleView() {
		gameView = new GameView();
	}
	
	@Override
	public void interact(Controller controller) {
		assert controller != null;
		controller.accept(this);
	}

	@Override
	public void visit(MoveDeckToDiscardsController moveDeckToWasteController) {
		gameView.interact(moveDeckToWasteController);
	}

	@Override
	public void visit(MoveDiscardsToDeckController moveDiscardsToDeckController) {
		gameView.interact(moveDiscardsToDeckController);
	}

	@Override
	public void visit(MoveDiscardsToFoundationController moveDiscardsToSuitController) {
		gameView.interact(moveDiscardsToSuitController);
	}


}
