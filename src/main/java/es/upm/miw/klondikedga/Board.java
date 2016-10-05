package es.upm.miw.klondikedga;

import java.util.ArrayList;

public class Board {

	private Menu menu;
	
	private Deck deck;
	
	private ArrayList<CardsStair> foundations;
	
	private ArrayList<CardsStair> boardStairs;
	
	private static final int FOUNDATIONS_NUM = 4;
	
	private static final int BOARDSTAIRS_NUM = 7;
	
	public Board() {
		menu = new Menu();
		deck = new Deck();
		foundations = new ArrayList<CardsStair>(FOUNDATIONS_NUM);
		boardStairs = new ArrayList<CardsStair>(BOARDSTAIRS_NUM);
	
		initDeck();
		initFoundations();
		initBoardStairs();
		
		deck.moveNextCardsToDiscards(3);
	}
	
	private void initDeck() {
		deck.initCards();
		deck.shuffle();
	}
	
	private void initFoundations() {
		foundations.add(new Foundation(Suit.COINS));
		foundations.add(new Foundation(Suit.CUPS));
		foundations.add(new Foundation(Suit.SWORDS));
		foundations.add(new Foundation(Suit.BASTOS));
	}
	
	private void initBoardStairs() {
		for(int i = BOARDSTAIRS_NUM-1; i >= 0; i--) {
			boardStairs.add(new BoardStair(deck.getGroupOfCards(1, i)));
		}
	}
	
	public void print() {
		System.out.println("===========================");
		deck.print();
		for(CardsStair cStair : foundations) {
			cStair.print();
		}
		int i = 0;
		for(CardsStair cStair : boardStairs) {
			System.out.print("Escalera " + (i + 1) + ": ");
			cStair.print();
			i++;
		}
		System.out.println("---------------------------");
		menu.print();
	}
	
	public ArrayList<CardsStair> getFoundations() {
		return foundations;
	}
	
	public ArrayList<CardsStair> getBoardStairs() {
		return boardStairs;
	}
	
}
