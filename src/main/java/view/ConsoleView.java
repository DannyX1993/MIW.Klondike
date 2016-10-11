package view;

import controller.OptionController;
import controller.FlipLastCardOfBoardStairController;
import controller.MoveBoardStairToBoardStairController;
import controller.MoveBoardStairToFoundationController;
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
	public void visitMoveDeckToDiscards(MoveDeckToDiscardsController moveDeckToWasteController) {
		gameView.interact(moveDeckToWasteController);
	}

	@Override
	public void visitMoveDiscardsToDeck(MoveDiscardsToDeckController moveDiscardsToDeckController) {
		gameView.interact(moveDiscardsToDeckController);
	}

	@Override
	public void visitMoveDiscardsToFoundation(MoveDiscardsToFoundationController moveDiscardsToSuitController) {
		gameView.interact(moveDiscardsToSuitController);
	}

	@Override
	public void visitMoveDiscardsToBoardStair(MoveDiscardsToBoardStairController moveDiscardsToStairController) {
		gameView.interact(moveDiscardsToStairController);
	}

	@Override
	public void visitMoveBoarsStairToBoardStair(MoveBoardStairToBoardStairController moveBoardStairToBoardStairController) {
		gameView.interact(moveBoardStairToBoardStairController);
	}

	@Override
	public void visitMoveBoardStairToFoundation(MoveBoardStairToFoundationController moveBoardStairToFoundationController) {
		gameView.interact(moveBoardStairToFoundationController);
	}

	@Override
	public void visitFlipLastCardOfBoardStair(FlipLastCardOfBoardStairController flipLastCardOfBoardStair) {
		gameView.interact(flipLastCardOfBoardStair);
	}


}
