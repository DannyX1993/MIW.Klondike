package es.upm.miw.klondikedga.utils;

public class ClosedInterval {
	
	private int min;
	
	private int max;
	
	public ClosedInterval(int min, int max) {
		assert min < max;
		this.min = min;
		this.max =  max;
	}
	
	
	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}
	
	public boolean isWithinRange(int value) {
		return value >= this.min && value <= this.max;
	}
	
	@Override
	public String toString() {
		return "[" + min + "-" + max + "]";
	}
	
}
