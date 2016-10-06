package model;

import java.util.ArrayList;

public class Board {

	private Menu menu;
	
	private Deck deck;
	
	private ArrayList<CardsStair> foundations;
	
	private ArrayList<CardsStair> boardStairs;
	
	private static final int FOUNDATIONS_NUM = 4;
	
	private static final int BOARDSTAIRS_NUM = 7;
	
	public Board() {
		deck = new Deck();
		foundations = new ArrayList<CardsStair>(FOUNDATIONS_NUM);
		boardStairs = new ArrayList<CardsStair>(BOARDSTAIRS_NUM);
		menu = new Menu();
	
		initDeck();
		initFoundations();
		initBoardStairs();
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
	
	public Menu getMenu() {
		return menu;
	}
	
	public ArrayList<Card> getDiscards() {
		return deck.getDiscards();
	}
	
	public int getNumCardsDeck() {
		return deck.getNumCards();
	}
	
	public int getNumCardsDiscards() {
		return deck.getDiscards().size();
	}
	
	public ArrayList<CardsStair> getFoundations() {
		return foundations;
	}
	
	public ArrayList<CardsStair> getBoardStairs() {
		return boardStairs;
	}
	
	public CardsStair getFoundationBySuit(Suit suit) {
		for(CardsStair cStair : foundations) {
			if(cStair.suit == suit) return cStair;
		}
		return null;
	}
	
	public void moveFromDeckToDiscards() {
		deck.moveNextCardsToDiscards(1);
	}
	
	public void moveFromDiscardsToDeck() {
		deck.moveAllDiscardsToDeck();
	}
	
	public void moveFromDiscardsToFoundation() {
		Card currentDiscard = deck.getLastDiscard();
		CardsStair foundation = getFoundationBySuit(currentDiscard.getSuit());
		ArrayList<Card> cardsToAdd = new ArrayList<Card>();
		cardsToAdd.add(currentDiscard);
		foundation.addCards(cardsToAdd);
	}
	
	public boolean canMoveDiscardToFoundation() {
		Card currentDiscard = deck.getLastDiscard();
		CardsStair foundation = getFoundationBySuit(currentDiscard.getSuit());
		ArrayList<Card> cardsToAdd = new ArrayList<Card>();
		cardsToAdd.add(currentDiscard);
		return foundation.canAddCards(cardsToAdd);
	}
	
}
