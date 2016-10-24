package es.upm.miw.klondikedga.controllers;

import java.util.ArrayList;

import es.upm.miw.klondikedga.models.Card;
import es.upm.miw.klondikedga.models.CardsStair;
import es.upm.miw.klondikedga.models.Game;
import es.upm.miw.klondikedga.models.Option;

public class MenuController {

	private Game game;
	
	public MenuController(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public int getBoardNumCardsInDeck() {
		return getGame().getBoard().getNumCardsDeck();
	}

	public int getBoardNumDiscards() {
		return getGame().getBoard().getNumCardsDiscards();
	}
	
	public String getStringDiscards() {
		String ret = "";
		for(Card card : getBoardDiscards()) {
			ret += card.toString();
		}
		return ret;
	}
	
	private ArrayList<Card> getBoardDiscards() {
		return getGame().getBoard().getDiscards();
	}
	
	public String getStringFoundations() {
		String ret = "";
		for(CardsStair cStair : getGame().getBoard().getFoundations()) {
			ret += cStair.toString() + "\n";
		}
		return ret;
	}
	
	public String getStringBoardStairs() {
		String ret = "";
		int i = 0;
		for(CardsStair cStair : getGame().getBoard().getBoardStairs()) {
			ret += "Escalera " + (i + 1) + ": ";
			ret += cStair.toString();
			i++;
		}
		return ret;
	}
	
	public String getStringOptionsMenu() {
		String ret = "";
		int i = 1;
		for(Option option: Option.values()) {
			ret += i + ". " + option.getText() + "\n";
			i++;
		}
		return ret;
	}
	
	public int accept(ControllerVisitor controllerVisitor) {
		return controllerVisitor.visitMenu(this);
	}
	
}
