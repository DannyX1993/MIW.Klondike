package es.upm.miw.klondikedga.controllers;

import java.util.ArrayList;

import es.upm.miw.klondikedga.models.Game;

public class MoveBoardStairToBoardStairController extends ActionSubDialogController {
	
	protected MoveBoardStairToBoardStairController(Game game, ArrayList<SubDialogController> subdialogControllers) {
		super(game, subdialogControllers);
	}
	
	public boolean isBoardStairEmpty(int numBoardStair) {
		return getGame().isBoardStairEmpty(numBoardStair);
	}
	
	public boolean areMoreCardsThanBoardStair(int numStair, int cardsNum) {
		return getGame().areMoreCardsThanBoardStair(numStair, cardsNum);
	}
	
	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveBoarsStairToBoardStair(this);
	}

	public String validateMoveWhenAreLessCardsThanBoardStair(int origStair, int cardsNum, int destStair) {
		String orig = getFirstNCardBoardStair(origStair, cardsNum);
		String dest = getLastCardBoardStairString(destStair);
		if(isBoardStairEmpty(destStair)) {
			if(!firstCardBoardStairOrigIsKing(origStair, cardsNum)){
				return Error.getError(Error.PUT_ERROR, orig, dest);
			} else {
				getGame().moveFromBoardStairToBoardStair(origStair, destStair, cardsNum);
			}
		} else {
			if(isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(origStair, cardsNum, destStair)
					|| !isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(origStair, cardsNum, destStair)){
				return Error.getError(Error.PUT_ERROR, orig, dest);
			} else {
				getGame().moveFromBoardStairToBoardStair(origStair, destStair, cardsNum);
			}
		}
		return null;
	}
	
	private boolean firstCardBoardStairOrigIsKing(int numBoardStair, int numCards) {
		return getGame().firstCardBoardStairOrigIsKing(numBoardStair, numCards);
	}
	
	private String getFirstNCardBoardStair(int numBoardStair, int cardsNum) {
		return getGame().getFirstNCardBoardStair(numBoardStair, cardsNum);
	}
	
	private String getLastCardBoardStairString(int numBoardStair) {
		return getGame().getLastCardBoardStairString(numBoardStair);
	}
	
	private boolean isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(int origStair, int numCards, int destStair) {
		return getGame().isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(origStair, numCards, destStair);
	}

	private boolean isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(int origStair, int numCards, int destStair) {
		return getGame().isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(origStair, numCards, destStair);
	}

}
