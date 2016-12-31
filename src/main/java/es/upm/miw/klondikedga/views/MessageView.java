package es.upm.miw.klondikedga.views;

import es.upm.miw.klondikedga.utils.IO;

public class MessageView {
	
	private String message;
	private IO io = new IO();
	
	public MessageView(String message) {
		this.io = new IO();
		this.message = message;
	}
	
	public void printMessage() {
		io.writeln("----------------------------------");
		io.writeln(this.message);
		io.writeln("----------------------------------");
	}
}
