package view;

import controller.OptionController;
import controller.ControllerVisitor;

public interface View extends ControllerVisitor {
	
	public void interact(OptionController controller);
	
}
