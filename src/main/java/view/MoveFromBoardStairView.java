package view;

import controller.SubDialogController;
import utils.LimitedIntDialog;

public class MoveFromBoardStairView {

SubDialogController subDialogController;
	
	MoveFromBoardStairView(SubDialogController subDialogController) {
		this.subDialogController = subDialogController;
	}
	
	public int getBoardStairOrig() {
		return new LimitedIntDialog("De qué escalera?", 7).read();
	}
	
}
