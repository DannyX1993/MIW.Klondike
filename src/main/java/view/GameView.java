package view;

import controller.OptionController;

import java.util.ArrayList;

import controller.ControllerVisitor;
import controller.Error;
import controller.MoveBoardStairToBoardStairController;
import controller.SubDialogController;
import controller.MoveDeckToDiscardsController;
import controller.MoveDiscardsToDeckController;
import controller.MoveDiscardsToFoundationController;
import controller.MoveDiscardsToBoardStairController;
import utils.IO;

public class GameView implements ControllerVisitor {

	private IO io = new IO();
	
	public void interact(OptionController controller) {
		controller.accept(this);
	}
	
	@Override
	public void visitMoveDeckToDiscardsController(MoveDeckToDiscardsController moveDeckToDiscardsController) {
		if(moveDeckToDiscardsController.getGame().deckIsEmpty()) { 
			io.writeln(Error.getError(Error.DECK_EMPTY));
		} else {
			moveDeckToDiscardsController.getGame().moveFromDeckToDiscards();
		}
	}

	@Override
	public void visitMoveDiscardsToDeckController(MoveDiscardsToDeckController moveDiscardsToDeckController) {
		if(!moveDiscardsToDeckController.getGame().deckIsEmpty()) {
			io.writeln(Error.getError(Error.DECK_WITH_CARDS));
		} else {
			moveDiscardsToDeckController.getGame().moveFromDiscardsToDeck();
		}
	}

	@Override
	public void visitMoveDiscardsToFoundationCotroller(MoveDiscardsToFoundationController moveDiscardsToFoundationController) {
		if(moveDiscardsToFoundationController.getGame().discardsIsEmpty()) {
			io.writeln(Error.getError(Error.NO_DISCARDS));
		} else if(moveDiscardsToFoundationController.getGame().isFirstCardToInsertInFoundation()) {
			if(!moveDiscardsToFoundationController.getGame().isLastDiscardAseOfSuit()) {
				io.writeln(Error.getError(Error.ISNT_ACE));
			} else {
				moveDiscardsToFoundationController.getGame().moveFromDiscardsToFoundation();
			}
		} else {
			if(!moveDiscardsToFoundationController.getGame().isOneNumGreaterOfFoundationLastCard()) {
				String orig = moveDiscardsToFoundationController.getGame().getLastDiscard().toString();
				String dest = moveDiscardsToFoundationController.getGame().getLastCardOfFoundation().toString();
				io.writeln(Error.getError(Error.PUT_ERROR, orig, dest));
			} else {
				moveDiscardsToFoundationController.getGame().moveFromDiscardsToFoundation();
			}
		}
	}

	@Override
	public void visitMoveDiscardsToBoardStairController(MoveDiscardsToBoardStairController moveDiscardsToStairController) {
		if(moveDiscardsToStairController.getGame().discardsIsEmpty()) {
			io.writeln(Error.getError(Error.NO_DISCARDS));
		} else {
			SubDialogController subdialogController = moveDiscardsToStairController.getSubDialogController();
			MoveToBoardStairView moveToBoardStairView = new MoveToBoardStairView(subdialogController);
			int destStair = getBoardStairDest(moveDiscardsToStairController, moveToBoardStairView);
			String orig = subdialogController.getGame().getLastDiscard().toString();
			String dest = subdialogController.getGame().getLastCardOfBoardStair(destStair).toString();
			if(!isBoardStairEmpty(moveDiscardsToStairController, destStair)) {
				if(subdialogController.getGame().isFirstCardToInsertInBoardStair(destStair) && !subdialogController.getGame().lastDiscardIsKing()){
					io.writeln(Error.getError(Error.ISNT_KING));
				} else if(subdialogController.getGame().lastCardOfBoardStairIsSameSuit(destStair) || !subdialogController.getGame().isOneNumLessThanLastCardBoardStair(destStair)) {
					io.writeln(Error.getError(Error.PUT_ERROR, orig, dest));
				} else {
					moveDiscardsToStairController.getGame().moveFromDiscardsToBoardStair(destStair);
				}
			} else {
				if(!subdialogController.getGame().lastDiscardIsKing()) {
					io.writeln(Error.getError(Error.PUT_ERROR, orig, dest));
				} else {
					moveDiscardsToStairController.getGame().moveFromDiscardsToBoardStair(destStair);
				}
			}
		}
	}
	
	@Override
	public void visitMoveBoarsStairToBoardStairController(MoveBoardStairToBoardStairController moveBoardStairToBoardStairController) {
		ArrayList<SubDialogController> subdialogControllers = moveBoardStairToBoardStairController.getSubDialogControllers();
		MoveFromBoardStairView moveFromBoardStairView = new MoveFromBoardStairView(subdialogControllers.get(0));
		int origStair = getBoardStairOrig(moveBoardStairToBoardStairController, moveFromBoardStairView);
		if(isBoardStairEmpty(moveBoardStairToBoardStairController, origStair)) {
			io.writeln(Error.getError(Error.STAIR_EMPTY));
		} else {
			int cardsNum = getNumCardsToMove(moveBoardStairToBoardStairController, new MoveNumCardsView(subdialogControllers.get(1)));
			if(areMoreCardsThanBoardStair(moveBoardStairToBoardStairController, origStair, cardsNum)){
				io.writeln(Error.getError(Error.MORE_CARDS_THAN_STAIR));
			} else {
				MoveToBoardStairView moveToBoardStairView = new MoveToBoardStairView(subdialogControllers.get(2));
				int destStair = getBoardStairDest(moveBoardStairToBoardStairController, moveToBoardStairView);
				String orig = getFirstNCardBoardStair(moveBoardStairToBoardStairController, origStair, cardsNum);
				String dest = getLastCardBoardStair(moveBoardStairToBoardStairController, destStair);
				if(isBoardStairEmpty(moveBoardStairToBoardStairController, destStair)) {
					if(!firstNCardBoardStairOrigIsKing(moveBoardStairToBoardStairController, origStair, cardsNum)){
						io.writeln(Error.getError(Error.PUT_ERROR, orig, dest));
					} else {
						moveBoardStairToBoardStairController.getGame().moveFromBoardStairToBoardStair(origStair, destStair, cardsNum);
					}
				} else {
					if(isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(moveBoardStairToBoardStairController, origStair, cardsNum, destStair)
							|| !isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(moveBoardStairToBoardStairController, origStair, cardsNum, destStair)){
						io.writeln(Error.getError(Error.PUT_ERROR, orig, dest));
					} else {
						moveBoardStairToBoardStairController.getGame().moveFromBoardStairToBoardStair(origStair, destStair, cardsNum);
					}
				}
			}
		}
	}
	
	private int getBoardStairOrig(OptionController moveBoardStairToBoardStairController, MoveFromBoardStairView moveFromBoardStairView) {
		return moveFromBoardStairView.getBoardStairOrig();
	}
	
	private boolean isBoardStairEmpty(OptionController moveBoardStairToBoarStairController, int numBoardStair) {
		return moveBoardStairToBoarStairController.isBoardStairEmpty(numBoardStair);
	}
	
	private int getNumCardsToMove(OptionController optionController, MoveNumCardsView moveNumCardsView) {
		return moveNumCardsView.getCardsNum();
	}
	
	private boolean areMoreCardsThanBoardStair(MoveBoardStairToBoardStairController moveBoardStairToBoarStairController, int numStair, int cardsNum) {
		return moveBoardStairToBoarStairController.areMoreCardsThanBoardStair(numStair, cardsNum);
	}
	
	private boolean firstNCardBoardStairOrigIsKing(MoveBoardStairToBoardStairController moveBoardStairToBoarStairController, int numBoardStair, int numCards) {
		return moveBoardStairToBoarStairController.firstCardBoardStairOrigIsKing(numBoardStair, numCards);
	}
	
	private String getFirstNCardBoardStair(MoveBoardStairToBoardStairController moveBoardStairToBoarStairController, int numBoardStair, int cardsNum) {
		return moveBoardStairToBoarStairController.getFirstNCardBoardStair(numBoardStair, cardsNum);
	}
	
	private String getLastCardBoardStair(MoveBoardStairToBoardStairController moveBoardStairToBoarStairController, int numBoardStair) {
		return moveBoardStairToBoarStairController.getLastCardBoardStair(numBoardStair);
	}
	
	private int getBoardStairDest(OptionController moveDiscardsToBoardStairController, MoveToBoardStairView moveToBoardStair) {
		return moveToBoardStair.getBoardStairDest();
	}
	
	private boolean isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(MoveBoardStairToBoardStairController moveBoardStairToBoarStairController, int origStair, int numCards, int destStair) {
		return moveBoardStairToBoarStairController.isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(origStair, numCards, destStair);
	}

	private boolean isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(MoveBoardStairToBoardStairController moveBoardStairToBoarStairController, int origStair, int numCards, int destStair) {
		return moveBoardStairToBoarStairController.isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(origStair, numCards, destStair);
	}
}
