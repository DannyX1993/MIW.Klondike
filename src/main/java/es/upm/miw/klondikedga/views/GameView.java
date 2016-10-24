package es.upm.miw.klondikedga.views;

import es.upm.miw.klondikedga.controllers.ControllerVisitor;
import es.upm.miw.klondikedga.controllers.Error;
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
import es.upm.miw.klondikedga.controllers.SubDialogController;
import es.upm.miw.klondikedga.utils.IO;

public class GameView implements ControllerVisitor {

	private IO io = new IO();
	
	public int interactWithMenu(MenuController menuController) {
		return menuController.accept(this);
	}
	
	public void interact(ActionController controller) {
		controller.accept(this);
	}
	
	@Override
	public int visitMenu(MenuController menuController) {
		MenuView menuView = new MenuView(menuController);
		return menuView.exploreMenu();
	}
	
	@Override
	public void visitMoveDeckToDiscards(MoveDeckToDiscardsController moveDeckToDiscardsController) {
		if(moveDeckToDiscardsController.getGame().deckIsEmpty()) { 
			io.writeln(Error.getError(Error.DECK_EMPTY));
		} else {
			moveDeckToDiscardsController.getGame().moveFromDeckToDiscards();
		}
	}

	@Override
	public void visitMoveDiscardsToDeck(MoveDiscardsToDeckController moveDiscardsToDeckController) {
		if(!moveDiscardsToDeckController.getGame().deckIsEmpty()) {
			io.writeln(Error.getError(Error.DECK_WITH_CARDS));
		} else {
			moveDiscardsToDeckController.getGame().moveFromDiscardsToDeck();
		}
	}

	@Override
	public void visitMoveDiscardsToFoundation(MoveDiscardsToFoundationController moveDiscardsToFoundationController) {
		if(moveDiscardsToFoundationController.getGame().discardsIsEmpty()) {
			io.writeln(Error.getError(Error.NO_DISCARDS));
		} else if(moveDiscardsToFoundationController.getGame().isFirstCardToInsertInFoundationFromDiscards()) {
			if(!moveDiscardsToFoundationController.getGame().isLastDiscardAseOfSuit()) {
				io.writeln(Error.getError(Error.ISNT_ACE));
			} else {
				moveDiscardsToFoundationController.getGame().moveFromDiscardsToFoundation();
			}
		} else {
			if(!moveDiscardsToFoundationController.getGame().isOneNumGreaterOfFoundationLastCardFromDiscard()) {
				String orig = moveDiscardsToFoundationController.getGame().getLastDiscard().toString();
				String dest = moveDiscardsToFoundationController.getGame().getLastCardOfFoundationFromDiscards().toString();
				io.writeln(Error.getError(Error.PUT_ERROR, orig, dest));
			} else {
				moveDiscardsToFoundationController.getGame().moveFromDiscardsToFoundation();
			}
		}
	}

	@Override
	public void visitMoveDiscardsToBoardStair(MoveDiscardsToBoardStairController moveDiscardsToStairController) {
		if(moveDiscardsToStairController.getGame().discardsIsEmpty()) {
			io.writeln(Error.getError(Error.NO_DISCARDS));
		} else {
			SubDialogController subdialogController = moveDiscardsToStairController.getSubDialogController();
			MoveSubDialogView moveToBoardStairView = new MoveSubDialogView();
			int destStair = getTargetBoardStair(moveToBoardStairView);
			String orig = subdialogController.getStringLastDiscard();
			String dest = subdialogController.getStringLastCardBoardStair(destStair);
			if(!isBoardStairEmpty(moveDiscardsToStairController, destStair)) {
				if(subdialogController.isFirstCardToInsertInBoardStair(destStair) && !subdialogController.lastDiscardIsKing()){
					io.writeln(Error.getError(Error.ISNT_KING));
				} else if(subdialogController.lastCardOfBoardStairIsSameSuit(destStair) || !subdialogController.isOneNumLessThanLastCardBoardStair(destStair)) {
					io.writeln(Error.getError(Error.PUT_ERROR, orig, dest));
				} else {
					moveDiscardsToStairController.getGame().moveFromDiscardsToBoardStair(destStair);
				}
			} else {
				if(!subdialogController.lastDiscardIsKing()) {
					io.writeln(Error.getError(Error.PUT_ERROR, orig, dest));
				} else {
					moveDiscardsToStairController.getGame().moveFromDiscardsToBoardStair(destStair);
				}
			}
		}
	}
	
	@Override
	public void visitMoveBoarsStairToBoardStair(MoveBoardStairToBoardStairController moveBoardStairToBoardStairController) {
		MoveSubDialogView moveFromBoardStairView = new MoveSubDialogView();
		int origStair = getBoardStairOrig(moveFromBoardStairView);
		if(isBoardStairEmpty(moveBoardStairToBoardStairController, origStair)) {
			io.writeln(Error.getError(Error.STAIR_EMPTY));
		} else {
			int cardsNum = getNumCardsToMove(new MoveSubDialogView());
			if(areMoreCardsThanBoardStair(moveBoardStairToBoardStairController, origStair, cardsNum)){
				io.writeln(Error.getError(Error.MORE_CARDS_THAN_STAIR));
			} else {
				MoveSubDialogView moveToBoardStairView = new MoveSubDialogView();
				int destStair = getTargetBoardStair(moveToBoardStairView);
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
	
	@Override
	public void visitMoveBoardStairToFoundation(MoveBoardStairToFoundationController moveBoardStairToFoundationController) {
		MoveSubDialogView moveFromBoardStairView = new MoveSubDialogView();
		int origStair = getBoardStairOrig(moveFromBoardStairView);
		if(moveBoardStairToFoundationController.getGame().isBoardStairEmpty(origStair)) {
			io.writeln(Error.getError(Error.STAIR_EMPTY));
		} else if(moveBoardStairToFoundationController.getGame().isFirstCardToInsertInFoundationFromBoardStair(origStair)) {
			if(!moveBoardStairToFoundationController.getGame().isLastCardOfBoardStairAseOfSuit(origStair)) {
				io.writeln(Error.getError(Error.ISNT_ACE));
			} else {
				moveBoardStairToFoundationController.getGame().moveFromBoardStairToFoundation(origStair);
			}
		} else {
			if(!moveBoardStairToFoundationController.getGame().isOneNumGreaterOfFoundationLastCardFromBoardStair(origStair)) {
				String orig = moveBoardStairToFoundationController.getGame().getLastCardBoardStair(origStair).toString();
				String dest = moveBoardStairToFoundationController.getGame().getLastCardOfFoundationFromBoardStair(origStair).toString();
				io.writeln(Error.getError(Error.PUT_ERROR, orig, dest));
			} else {
				moveBoardStairToFoundationController.getGame().moveFromBoardStairToFoundation(origStair);
			}
		}
	}
	
	@Override
	public void visitMoveFoundationToBoardStair(MoveFoundationToBoardStairController moveFoundationToBoardStairController) {
		MoveSubDialogView moveFromFoundationView = new MoveSubDialogView();
		int origFoundation = getOriginFoundation(moveFromFoundationView);
		MoveSubDialogView moveToBoardStairView = new MoveSubDialogView();
		int destBoardStair = getTargetBoardStair(moveToBoardStairView);
		System.out.println("origFoundation: " + origFoundation + "\ndestBoardStair: " + destBoardStair);
		/*String orig = getFirstNCardBoardStair(moveFoundationToBoardStairController, origStair, cardsNum);
		String dest = getLastCardBoardStair(moveFoundationToBoardStairController, destBoardStair);*/
	}

	@Override
	public void visitFlipLastCardOfBoardStair(FlipLastCardOfBoardStairController flipLastCardOfBoardStair) {
		MoveSubDialogView moveFromBoardStairView = new MoveSubDialogView();
		int origStair = getBoardStairOrig(moveFromBoardStairView);
		if(flipLastCardOfBoardStair.getGame().isBoardStairEmpty(origStair)) {
			io.writeln(Error.getError(Error.STAIR_EMPTY));
		} else {
			if(flipLastCardOfBoardStair.getGame().getLastCardBoardStair(origStair).getUpturned()) {
				io.writeln(Error.getError(Error.CANT_FLIP));
			} else {
				flipLastCardOfBoardStair.getGame().flipLastCardOfBoardStair(origStair);
			}
		}
	}
	
	private boolean isBoardStairEmpty(ActionController moveBoardStairToBoarStairController, int numBoardStair) {
		return moveBoardStairToBoarStairController.isBoardStairEmpty(numBoardStair);
	}
	
	private int getBoardStairOrig(MoveSubDialogView moveFromBoardStairView) {
		return moveFromBoardStairView.getMoveResponse("De qué escalera?", 7);
	}
	
	private int getOriginFoundation(MoveSubDialogView moveFoundationView) {
		return moveFoundationView.getMoveResponse("De qué palo?", 4);
	}
	
	private int getNumCardsToMove(MoveSubDialogView moveNumCardsView) {
		return moveNumCardsView.getMoveResponse("Cuántas cartas?", 13);
	}
	
	private int getTargetBoardStair(MoveSubDialogView moveToBoardStairView) {
		return moveToBoardStairView.getMoveResponse("A qué escalera?", 7);
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
		return moveBoardStairToBoarStairController.getLastCardBoardStairString(numBoardStair);
	}
	
	private boolean isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(MoveBoardStairToBoardStairController moveBoardStairToBoarStairController, int origStair, int numCards, int destStair) {
		return moveBoardStairToBoarStairController.isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(origStair, numCards, destStair);
	}

	private boolean isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(MoveBoardStairToBoardStairController moveBoardStairToBoarStairController, int origStair, int numCards, int destStair) {
		return moveBoardStairToBoarStairController.isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(origStair, numCards, destStair);
	}

}
