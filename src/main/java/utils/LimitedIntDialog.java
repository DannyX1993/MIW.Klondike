package utils;

import view.ClosedIntervalView;

public class LimitedIntDialog {
	
	private String title;
	
	private ClosedInterval limits;
	
	private ClosedIntervalView limitsView;
	
	public LimitedIntDialog(String title, int min, int max) {
		assert title != null;
		limits = new ClosedInterval(min, max);
		limitsView = new ClosedIntervalView("ERROR!!! La opción debe ser entre ", limits);
		this.title = title + " [" + limits + "]: ";
	}
	
	public LimitedIntDialog(String title, int max) {
		this(title, 1, max);
	}
	
	public int read() {
		IO io = new IO();
		int value;
		boolean ok;
		do {
			value = io.readInt(title);
			ok = limits.isWithinRange(value);
			if(!ok) {
				limitsView.writln();
			}
		} while(!ok);
		return value;
	}
	
}
