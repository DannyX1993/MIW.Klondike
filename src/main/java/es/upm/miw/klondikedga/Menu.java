package es.upm.miw.klondikedga;

import java.util.ArrayList;

public class Menu {

	private ArrayList<Option> options;
	
	public Menu() {
		options = new ArrayList<Option>();
		initMenuOptions();
	}
	
	private void initMenuOptions() {
		for(Option option : Option.values()) {
			options.add(option);
		}
	}
	
	public Option getOptionByNum(int num) {
		assert num > 0;
		return options.get(num - 1);
	}
	
	public void print() {
		for(Option option : options) {
			System.out.println(option.getNum() + ". " + option.getText());
		}
	}
	
}
