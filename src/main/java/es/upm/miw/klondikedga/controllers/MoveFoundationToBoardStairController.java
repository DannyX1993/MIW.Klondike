package es.upm.miw.klondikedga.controllers;

import java.util.ArrayList;

import es.upm.miw.klondikedga.models.Card;
import es.upm.miw.klondikedga.models.Game;

public class MoveFoundationToBoardStairController extends ActionSubDialogController {


	protected MoveFoundationToBoardStairController(Game game, ArrayList<SubDialogController> subdialogControllers) {
		super(game, subdialogControllers);
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visitMoveFoundationToBoardStair(this);
	}

	private String getStringFirstCardFoundation(int origFoundation) {
		return getGame().getBoard().getFoundations().get(origFoundation - 1).getLastCard().toString();
	}

	public boolean isFoundationEmpty(int origFoundation) {
		return getGame().isFoundationEmpty(origFoundation);
	}

	private String getStringLastCardBoardStair(int destStair) {
		return getGame().getStringLastCardBoardStair(destStair);
	}

	public String validateMoveWhenFoundationIsntEmpty(int numFoundation, int destStair) {
		Card lastBoardStairCard = getGame().getLastCardBoardStair(destStair);
		if((lastBoardStairCard == null || !lastBoardStairCard.getUpturned()) && getGame().lastFoundationCardIsKing(numFoundation)) {
			getGame().moveFromFoundationToBoardStair(numFoundation, destStair);
		} else if(lastBoardStairCard == null || !lastBoardStairCard.getUpturned()) {
			return Error.getError(Error.ISNT_KING);
		} else if(getGame().lastFoundationIsOneNumLessThanLastCardBoardStair(numFoundation, destStair) && 
				!getGame().lastCardOfBoardStairIsSameSuitThanLastFoundationCard(numFoundation, destStair)) {
			getGame().moveFromFoundationToBoardStair(numFoundation, destStair);
		} else {
			String orig = getStringFirstCardFoundation(numFoundation);
			String dest = getStringLastCardBoardStair(destStair);
			return Error.getError(Error.PUT_ERROR, orig, dest);
		}
		return null;
	}

}
