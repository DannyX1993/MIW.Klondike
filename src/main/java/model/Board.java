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
	
	public Card getLastDiscard() {
		return deck.getLastDiscard();
	}
	
	public ArrayList<CardsStair> getFoundations() {
		return foundations;
	}
	
	public ArrayList<CardsStair> getBoardStairs() {
		return boardStairs;
	}
	
	public CardsStair getBoardStair(int numStair) {
		return boardStairs.get(numStair - 1);
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
	
	public boolean isFirstCardToInsertInFoundation() {
		Card currentDiscard = deck.getLastDiscard();
		CardsStair stair = getFoundationBySuit(currentDiscard.getSuit());
		return stair.getNumCards() == 0;
	}
	
	public boolean isLastDiscardAceOfSuit() {
		return getLastDiscard().getNum() == SymbolsCard.ACE.getNum();
	}
	
	public boolean isOneNumGreaterOfFoundationLastCard() {
		Card currentDiscard = deck.getLastDiscard();
		CardsStair foundation = getFoundationBySuit(currentDiscard.getSuit());
		Card lastStairCard = foundation.getLastCard();
		return (foundation.suit == currentDiscard.getSuit() && currentDiscard.getNum() == lastStairCard.getNum() + 1);
	}
	
	public Card getLastCardOfFoundation() {
		Card currentDiscard = deck.getLastDiscard();
		CardsStair foundation = getFoundationBySuit(currentDiscard.getSuit());
		return foundation.getLastCard();
	}
	
	public boolean canMoveDiscardToFoundation() {
		Card currentDiscard = deck.getLastDiscard();
		CardsStair foundation = getFoundationBySuit(currentDiscard.getSuit());
		ArrayList<Card> cardsToAdd = new ArrayList<Card>();
		cardsToAdd.add(currentDiscard);
		return foundation.canAddCards(cardsToAdd);
	}
	
	public void moveFromDiscardsToFoundation() {
		Card currentDiscard = deck.extractLastDiscard();
		CardsStair foundation = getFoundationBySuit(currentDiscard.getSuit());
		ArrayList<Card> cardsToAdd = new ArrayList<Card>();
		cardsToAdd.add(currentDiscard);
		foundation.addCards(cardsToAdd);
	}
	
	public boolean isFirstCardToInsertInBoardStair(int numBoardStair) {
		assert numBoardStair > 0;
		return getBoardStair(numBoardStair).getNumCards() == 0;
	}
	
	public boolean lastDiscardIsKing() {
		return getLastDiscard().getNum() == SymbolsCard.KING.getNum();
	}
	
	public boolean lastCardOfBoardStairIsSameSuit(int numBoardStair) {
		assert numBoardStair > 0;
		Card currentDiscard = deck.getLastDiscard();
		return getBoardStair(numBoardStair).getLastCard().getSuit() == currentDiscard.getSuit();
	}
	
	public Card getLastCardOfBoardStair(int numBoardStair) {
		assert numBoardStair > 0;
		return getBoardStair(numBoardStair).getLastCard();
	}
	
	public boolean isOneNumLessThanLastCardBoardStair(int numBoardStair){
		assert numBoardStair > 0;
		Card currentDiscard = deck.getLastDiscard();
		return (getBoardStair(numBoardStair).getLastCard().getNum() - 1) == currentDiscard.getNum();
	}
	
	public void moveFromDiscardsToBoardStair(int numBoardStair) {
		assert numBoardStair > 0;
		Card currentDiscard = deck.extractLastDiscard();
		CardsStair cStair = getBoardStair(numBoardStair);
		ArrayList<Card> cardsToAdd = new ArrayList<Card>();
		cardsToAdd.add(currentDiscard);
		cStair.addCards(cardsToAdd);
	}
	
}
