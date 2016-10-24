package es.upm.miw.klondikedga.utils;

import es.upm.miw.klondikedga.views.ClosedIntervalView;

public class LimitedIntDialog {
	
	private IntDialog intDialog;
	
	private ClosedInterval limits;
	
	private ClosedIntervalView limitsView;
	
	public LimitedIntDialog(String title, int min, int max) {
		assert title != null;
		intDialog = new IntDialog(title);
		limits = new ClosedInterval(min, max);
		limitsView = new ClosedIntervalView("ERROR!!! La opción debe ser entre ", limits);
		intDialog.setTitle(title + " [" + limits + "]: ");
	}
	
	public LimitedIntDialog(String title, int max) {
		this(title, 1, max);
	}
	
	public int read() {
		IO io = new IO();
		int value;
		boolean ok;
		do {
			value = io.readInt(intDialog.getTitle());
			ok = limits.isWithinRange(value);
			if(!ok) {
				limitsView.writln();
			}
		} while(!ok);
		return value;
	}
	
}
