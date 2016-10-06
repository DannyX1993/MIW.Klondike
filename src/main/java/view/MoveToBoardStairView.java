package view;

import controller.SubDialogController;
import utils.LimitedIntDialog;

public class MoveToBoardStairView {

	SubDialogController subDialogController;
	
	MoveToBoardStairView(SubDialogController subDialogController) {
		this.subDialogController = subDialogController;
	}
	
	public int getBoardStairDest() {
		return new LimitedIntDialog("A qué escalera?", 7).read();
	}

}
