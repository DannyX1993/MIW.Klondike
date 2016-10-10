package view;

import controller.SubDialogController;
import utils.IntDialog;

public class MoveNumCardsView {

	SubDialogController subDialogController;
	
	MoveNumCardsView(SubDialogController subDialogController) {
		this.subDialogController = subDialogController;
	}
	
	public int getCardsNum() {
		return new IntDialog("Cuántas cartas?").read();
	}
	
}
