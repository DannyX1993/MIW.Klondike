package controller;

import model.Game;

public class MoveDiscardsToFoundationController extends Controller {

	protected MoveDiscardsToFoundationController(Game game) {
		super(game);
	}

	@Override
	public Error validateMove() {
		if(isFirstCard()) {
			if(!isAseOfSuit()) return Error.DECK_WITH_CARDS;
		} else {
			if(!isOneGraterNumOfSuit()) return Error.DECK_EMPTY;
		}
		return null;
	}
	
	private boolean isFirstCard(){
		// TODO -> Implementar
		return true;
	}
	
	private boolean isAseOfSuit() {
		// TODO -> Implementar
		return true;
	}
	
	private boolean isOneGraterNumOfSuit() {
		// TODO -> Implementar
		return true;
	}

	@Override
	public void accept(ControllerVisitor controllerVisitor) {
		controllerVisitor.visit(this);
	}

}
