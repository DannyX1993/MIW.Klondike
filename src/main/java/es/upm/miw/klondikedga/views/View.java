package es.upm.miw.klondikedga.views;

import es.upm.miw.klondikedga.controllers.ControllerVisitor;
import es.upm.miw.klondikedga.controllers.MenuController;
import es.upm.miw.klondikedga.controllers.ActionController;

public interface View extends ControllerVisitor {

	public int interactWithMenu(MenuController menuController);
	
	public void interact(ActionController controller);
	
}
