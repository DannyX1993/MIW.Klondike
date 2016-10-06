package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {

	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	public String readString(String title) {
		String input = null;
		boolean ok = false;
		do {
			try {
				System.out.print(title);
				input = bufferedReader.readLine();
				ok = true;
			} catch (IOException e) {
				System.out.println("Error");
			}
		} while(!ok);
		return input;
	}
	
	public int readInt(String title) {
		int input = 0;
		boolean ok = false;
		do {
			try {
				input = Integer.parseInt(this.readString(title));
				ok = true;
			} catch(Exception ex) {
				System.out.println("ERROR DE FORMATO!!! Sólo se admiten números");
			}
		} while(!ok);
		return input;
	}
	
	public void writeln() {
		System.out.println();
	}
	
	public void writeln(String text) {
		System.out.println(text);
	}
	
	public void write(String text) {
		System.out.print(text);
	}
	
}
