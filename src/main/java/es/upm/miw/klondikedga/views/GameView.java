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
import es.upm.miw.klondikedga.utils.IO;

public class GameView implements ControllerVisitor {

	private IO io = new IO();
	
	private final String FROM_STAIR_TXT = "A qué escalera?";
	
	private final String TO_STAIR_TXT = "De qué escalera?";
	
	private final String CARD_QUANTITY_TXT = "Cuántas cartas?";
	
	private final String FROM_FOUNDATION_TXT = "De qué palo?";
	
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
	public void visitMoveDeckToDiscards(MoveDeckToDiscardsController controller) {
		if(controller.getGame().deckIsEmpty()) { 
			io.writeln(Error.getError(Error.DECK_EMPTY));
		} else {
			controller.getGame().moveFromDeckToDiscards();
		}
	}

	@Override
	public void visitMoveDiscardsToDeck(MoveDiscardsToDeckController controller) {
		if(!controller.getGame().deckIsEmpty()) {
			io.writeln(Error.getError(Error.DECK_WITH_CARDS));
		} else {
			controller.getGame().moveFromDiscardsToDeck();
		}
	}

	@Override
	public void visitMoveDiscardsToFoundation(MoveDiscardsToFoundationController controller) {
		if(controller.getGame().discardsIsEmpty()) {
			io.writeln(Error.getError(Error.NO_DISCARDS));
		} else if(controller.getGame().isFirstCardToInsertInFoundationFromDiscards()) {
			if(!controller.getGame().isLastDiscardAseOfSuit()) {
				io.writeln(Error.getError(Error.ISNT_ACE));
			} else {
				controller.getGame().moveFromDiscardsToFoundation();
			}
		} else {
			if(!controller.getGame().isOneNumGreaterOfFoundationLastCardFromDiscard()) {
				String orig = controller.getGame().getLastDiscard().toString();
				String dest = controller.getGame().getLastCardOfFoundationFromDiscards().toString();
				io.writeln(Error.getError(Error.PUT_ERROR, orig, dest));
			} else {
				controller.getGame().moveFromDiscardsToFoundation();
			}
		}
	}

	@Override
	public void visitMoveDiscardsToBoardStair(MoveDiscardsToBoardStairController controller) {
		String err;
		if(controller.getGame().discardsIsEmpty()) {
			err = Error.getError(Error.NO_DISCARDS);
		} else {
			int destStair = new MoveSubDialogView().getMoveResponse(FROM_STAIR_TXT, 7);
			if(!controller.isBoardStairEmpty(destStair)) {
				err = controller.validateMoveWhenIsntBoardStairEmpty(destStair);
			} else {
				err = controller.validateMoveWhenIsBoardStairEmpty(destStair);
			}
		}
		if(err != null) {
			io.writeln(err);
		}
	}
	
	@Override
	public void visitMoveBoarsStairToBoardStair(MoveBoardStairToBoardStairController controller) {
		String err;
		int origStair = new MoveSubDialogView().getMoveResponse(TO_STAIR_TXT, 7);
		if(controller.isBoardStairEmpty(origStair)) {
			err = Error.getError(Error.STAIR_EMPTY);
		} else {
			int cardsNum = new MoveSubDialogView().getMoveResponse(CARD_QUANTITY_TXT, 13);
			if(controller.areMoreCardsThanBoardStair(origStair, cardsNum)){
				err = Error.getError(Error.MORE_CARDS_THAN_STAIR);
			} else {
				int destStair = new MoveSubDialogView().getMoveResponse(FROM_STAIR_TXT, 7);
				err = controller.validateMoveWhenAreLessCardsThanBoardStair(origStair, cardsNum, destStair);
			}
		}
		if(err != null) {
			io.writeln(err);
		}
	}
	
	@Override
	public void visitMoveBoardStairToFoundation(MoveBoardStairToFoundationController controller) {
		String err;
		int origStair = new MoveSubDialogView().getMoveResponse(TO_STAIR_TXT, 7);
		if(controller.getGame().isBoardStairEmpty(origStair)) {
			err = Error.getError(Error.STAIR_EMPTY);
		} else if(controller.getGame().isFirstCardToInsertInFoundationFromBoardStair(origStair)) {
			err = controller.validateMoveWhenIsFirstCardInFoundation(origStair);
		} else {
			err = controller.validateMoveWhenIsntFirstCardInFoundation(origStair);
		}
		if(err != null) {
			io.writeln(err);
		}
	}
	
	@Override
	public void visitMoveFoundationToBoardStair(MoveFoundationToBoardStairController controller) {
		int origFoundation = new MoveSubDialogView().getMoveResponse(FROM_FOUNDATION_TXT, 4);
		if(!controller.isFoundationEmpty(origFoundation)) {
			int destFoundation = new MoveSubDialogView().getMoveResponse(FROM_STAIR_TXT, 7);
			// TODO -> COMPROBAR EL PALO Y EL VALOR DE LA ÚLTIMA CARTA DE LA ESCALERA DESTINO
			// TODO -> SUSTITUIR CONSTANTES DE LOS LIMITES POR VARIABLES
			String orig = controller.getStringFirstCardFoundation(origFoundation);
			String dest = controller.getLastCardFoundation(destFoundation);
		} else {
			io.writeln(Error.getError(Error.FOUNDATION_EMPTY));
		}
	}

	@Override
	public void visitFlipLastCardOfBoardStair(FlipLastCardOfBoardStairController controller) {
		String err;
		int origStair = new MoveSubDialogView().getMoveResponse(TO_STAIR_TXT, 7);
		if(controller.getGame().isBoardStairEmpty(origStair)) {
			err = Error.getError(Error.STAIR_EMPTY);
		} else {
			err = controller.validateMoveWhenBoardIsntEmpty(origStair);
		}
		if(err != null) {
			io.writeln(err);
		}
	}

}