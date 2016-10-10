package utils;

public class IntDialog {
	
	private String title;
	
	public IntDialog(String title) {
		assert title != null;
		this.title = title + ": ";
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int read() {
		IO io = new IO();
		int value;
		value = io.readInt(title);
		return value;
	}
	
}
