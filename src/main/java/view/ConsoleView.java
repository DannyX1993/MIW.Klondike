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
	public void visitMoveDeckToDiscardsController(MoveDeckToDiscardsController moveDeckToWasteController) {
		gameView.interact(moveDeckToWasteController);
	}

	@Override
	public void visitMoveDiscardsToDeckController(MoveDiscardsToDeckController moveDiscardsToDeckController) {
		gameView.interact(moveDiscardsToDeckController);
	}

	@Override
	public void visitMoveDiscardsToFoundationCotroller(MoveDiscardsToFoundationController moveDiscardsToSuitController) {
		gameView.interact(moveDiscardsToSuitController);
	}

	@Override
	public void visitMoveDiscardsToBoardStairController(MoveDiscardsToBoardStairController moveDiscardsToStairController) {
		gameView.interact(moveDiscardsToStairController);
	}

	@Override
	public void visitMoveBoarsStairToBoardStairController(MoveBoardStairToBoardStairController moveBoardStairToBoardStairController) {
		gameView.interact(moveBoardStairToBoardStairController);
	}


}
