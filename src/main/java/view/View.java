package view;

import controller.Controller;
import controller.ControllerVisitor;

public interface View extends ControllerVisitor {
	
	public void interact(Controller controller);
	
}
