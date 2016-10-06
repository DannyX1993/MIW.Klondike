package view;

import controller.OptionController;
import controller.MoveBoardStairToBoardStairController;
import controller.MoveDeckToDiscardsController;
import controller.MoveDiscardsToDeckController;
import controller.MoveDiscardsToFoundationController;
import controller.MoveDiscardsToBoardStairController;

public class ConsoleView implements View {
	
	private GameView gameView;
	
	public ConsoleView() {
		gameView = new GameView();
	}
	
	@Override
	public void interact(OptionController controller) {
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

	@Override
	public void visit(MoveDiscardsToBoardStairController moveDiscardsToStairController) {
		gameView.interact(moveDiscardsToStairController);
	}

	@Override
	public void visit(MoveBoardStairToBoardStairController moveBoardStairToBoardStairController) {
		gameView.interact(moveBoardStairToBoardStairController);
	}


}
