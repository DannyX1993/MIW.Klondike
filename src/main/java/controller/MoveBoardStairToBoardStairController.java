package controller;

import java.util.ArrayList;

import model.Game;

public class MoveBoardStairToBoardStairController extends OptionSubDialogController {

	private ArrayList<SubDialogController> subdialogControllers;
	
	protected MoveBoardStairToBoardStairController(Game game, ArrayList<SubDialogController> subdialogControllers) {
		super(game, subdialogControllers);
	}
	
	public boolean isBoardStairEmpty(int numBoardStair) {
		return getGame().isBoardStairEmpty(numBoardStair);
	}
	
	public boolean areMoreCardsThanBoardStair(int numStair, int cardsNum) {
		return getGame().areMoreCardsThanBoardStair(numStair, cardsNum);
	}
	
	public boolean firstCardBoardStairOrigIsKing(int numBoardStair, int numCards) {
		return getGame().firstCardBoardStairOrigIsKing(numBoardStair, numCards);
	}
	
	public String getFirstNCardBoardStair(int numBoardStair, int cardsNum) {
		return getGame().getFirstNCardBoardStair(numBoardStair, cardsNum);
	}
	
	public String getLastCardBoardStairString(int numBoardStair) {
		return getGame().getLastCardBoardStairString(numBoardStair);
	}
	
	public boolean isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(int origStair, int numCards, int destStair) {
		return getGame().isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(origStair, numCards, destStair);
	}

	public boolean isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(int origStair, int numCards, int destStair) {
		return getGame().isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(origStair, numCards, destStair);
	}
	
	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveBoarsStairToBoardStair(this);
	}

}
