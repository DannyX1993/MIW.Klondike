package controller;

public interface ControllerVisitor {
	
	void visit(MoveDeckToDiscardsController moveDeckToWasteController);
	
	void visit(MoveDiscardsToDeckController moveDiscardsToDeckController);
	
	void visit(MoveDiscardsToFoundationController moveDiscardsToFoundationController);
	
}
