package controller;

import java.util.ArrayList;

import model.Game;

public class MoveBoardStairToBoardStairController extends OptionController {

	private ArrayList<SubDialogController> subdialogControllers;
	
	protected MoveBoardStairToBoardStairController(Game game, ArrayList<SubDialogController> subdialogControllers) {
		super(game);
		assert subdialogControllers != null;
		this.subdialogControllers = subdialogControllers;
	}
	
	public ArrayList<SubDialogController> getSubDialogControllers() {
		return subdialogControllers;
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
	
	public String getLastCardBoardStair(int numBoardStair) {
		return getGame().getLastCardBoardStair(numBoardStair);
	}
	
	public boolean isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(int origStair, int numCards, int destStair) {
		return getGame().isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(origStair, numCards, destStair);
	}

	public boolean isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(int origStair, int numCards, int destStair) {
		return getGame().isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(origStair, numCards, destStair);
	}
	
	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveBoarsStairToBoardStairController(this);
	}

}
