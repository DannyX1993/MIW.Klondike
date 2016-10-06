package controller;

public interface ControllerVisitor {
	
	void visit(MoveDeckToDiscardsController moveDeckToWasteController);
	
	void visit(MoveDiscardsToDeckController moveDiscardsToDeckController);
	
	void visit(MoveDiscardsToFoundationController moveDiscardsToFoundationController);
	
	void visit(MoveDiscardsToBoardStairController moveDiscardsToStairController);
	
	void visit(MoveBoardStairToBoardStairController moveBoardStairToBoardStairController);
	
}
