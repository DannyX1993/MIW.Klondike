package es.upm.miw.klondikedga.views;

import es.upm.miw.klondikedga.utils.LimitedIntDialog;

public class MoveSubDialogView {

	public MoveSubDialogView() { }
	
	public int getMoveResponse(String text, int limit) {
		return new LimitedIntDialog(text, limit).read();
	}
	
}
