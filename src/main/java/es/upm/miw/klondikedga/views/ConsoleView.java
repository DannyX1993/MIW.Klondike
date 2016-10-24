package es.upm.miw.klondikedga.views;

import es.upm.miw.klondikedga.controllers.FlipLastCardOfBoardStairController;
import es.upm.miw.klondikedga.controllers.MenuController;
import es.upm.miw.klondikedga.controllers.MoveBoardStairToBoardStairController;
import es.upm.miw.klondikedga.controllers.MoveBoardStairToFoundationController;
import es.upm.miw.klondikedga.controllers.MoveDeckToDiscardsController;
import es.upm.miw.klondikedga.controllers.MoveDiscardsToBoardStairController;
import es.upm.miw.klondikedga.controllers.MoveDiscardsToDeckController;
import es.upm.miw.klondikedga.controllers.MoveDiscardsToFoundationController;
import es.upm.miw.klondikedga.controllers.MoveFoundationToBoardStairController;
import es.upm.miw.klondikedga.controllers.ActionController;

public class ConsoleView implements View {
	
	private GameView gameView;
	
	public ConsoleView() {
		gameView = new GameView();
	}
	
	@Override
	public void interact(ActionController controller) {
		assert controller != null;
		controller.accept(this);
	}
	
	@Override
	public int interactWithMenu(MenuController menuController) {
		assert menuController != null;
		return menuController.accept(this);
	}

	@Override
	public int visitMenu(MenuController menuController) {
		return gameView.interactWithMenu(menuController);
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
	public void visitMoveFoundationToBoardStair(MoveFoundationToBoardStairController moveFoundationToBoardStairController) {
		gameView.visitMoveFoundationToBoardStair(moveFoundationToBoardStairController);
	}
	
	@Override
	public void visitFlipLastCardOfBoardStair(FlipLastCardOfBoardStairController flipLastCardOfBoardStair) {
		gameView.interact(flipLastCardOfBoardStair);
	}

}
