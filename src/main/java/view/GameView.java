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
	public void visit(MoveDeckToDiscardsController moveDeckToDiscardsController) {
		if(moveDeckToDiscardsController.getGame().deckIsEmpty()) { 
			io.writeln(Error.getError(Error.DECK_EMPTY));
		} else {
			moveDeckToDiscardsController.getGame().moveFromDeckToDiscards();
		}
	}

	@Override
	public void visit(MoveDiscardsToDeckController moveDiscardsToDeckController) {
		if(!moveDiscardsToDeckController.getGame().deckIsEmpty()) {
			io.writeln(Error.getError(Error.DECK_WITH_CARDS));
		} else {
			moveDiscardsToDeckController.getGame().moveFromDiscardsToDeck();
		}
	}

	@Override
	public void visit(MoveDiscardsToFoundationController moveDiscardsToFoundationController) {
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
	public void visit(MoveDiscardsToBoardStairController moveDiscardsToStairController) {
		if(moveDiscardsToStairController.getGame().discardsIsEmpty()) {
			io.writeln(Error.getError(Error.NO_DISCARDS));
		} else {
			SubDialogController subdialogController = moveDiscardsToStairController.getSubDialogController();
			MoveToBoardStairView moveToBoardStairView = new MoveToBoardStairView(subdialogController);
			int destStair = getBoardStairDest(moveDiscardsToStairController, moveToBoardStairView);
			if(subdialogController.getGame().isFirstCardToInsertInBoardStair(destStair) && !subdialogController.getGame().lastDiscardIsKing()){
				io.writeln(Error.getError(Error.ISNT_KING));
			} else if(subdialogController.getGame().lastCardOfBoardStairIsSameSuit(destStair) || !subdialogController.getGame().isOneNumLessThanLastCardBoardStair(destStair)) {
				String orig = subdialogController.getGame().getLastDiscard().toString();
				String dest = subdialogController.getGame().getLastCardOfBoardStair(destStair).toString();
				io.writeln(Error.getError(Error.PUT_ERROR, orig, dest));
			} else {
				moveDiscardsToStairController.getGame().moveFromDiscardsToBoardStair(destStair);
			}
		}
	}
	
	@Override
	public void visit(MoveBoardStairToBoardStairController moveBoardStairToBoardStairController) {
		ArrayList<SubDialogController> subdialogControllers = moveBoardStairToBoardStairController.getSubDialogControllers();
		MoveFromBoardStairView moveFromBoardStairView = new MoveFromBoardStairView(subdialogControllers.get(0));
		int origStair = getBoardStairOrig(moveBoardStairToBoardStairController, moveFromBoardStairView);
		// TODO -> COMPROBAR SI ESTÁ VACÍA SI LO ESTÁ ERROR
		// TODO -> IMPLEMENTAR LA VISTA DE CUANTAS CARTAS QUIERES MOVER COMPROBANDO EL ERROR DE SI SUPERA LAS CARTAS DE LA ESCALERA ELEGIDA
		MoveToBoardStairView moveToBoardStairView = new MoveToBoardStairView(subdialogControllers.get(1));
		int destStair = getBoardStairDest(moveBoardStairToBoardStairController, moveToBoardStairView);
		// TODO -> COMPROBAR SI ESTÁ VACÍA Y SI LO ESTÁ COMPROBAR SI LA PRIMERA CARTA ES REY. SI NO ESTÁ VACÍA COMPROBAR QUE ES UN NUMERO MENOR Y DE DISTINTO PALO A LA ULTIMA CARTA DE LA ESCALERA
	}
	
	private int getBoardStairOrig(OptionController moveBoardStairToBoardStairController, MoveFromBoardStairView moveFromBoardStairView) {
		return moveFromBoardStairView.getBoardStairOrig();
	}
	
	private int getBoardStairDest(OptionController moveDiscardsToBoardStairController, MoveToBoardStairView moveToBoardStair) {
		return moveToBoardStair.getBoardStairDest();
	}

}
