package es.upm.miw.klondikedga.models;

import java.util.ArrayList;

public class Board {
	
	private Deck deck;
	
	private ArrayList<CardsStair> foundations;
	
	private ArrayList<CardsStair> boardStairs;
	
	private static final int FOUNDATIONS_NUM = 4;
	
	private static final int BOARDSTAIRS_NUM = 7;
	
	public Board() {
		deck = new Deck();
		foundations = new ArrayList<CardsStair>(FOUNDATIONS_NUM);
		boardStairs = new ArrayList<CardsStair>(BOARDSTAIRS_NUM);
	
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
	
	public CardsStair getFoundation(int numFoundation) {
		return foundations.get(numFoundation - 1);
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
	
	public boolean isFirstCardToInsertInFoundationFromDiscards() {
		Card currentDiscard = deck.getLastDiscard();
		CardsStair stair = getFoundationBySuit(currentDiscard.getSuit());
		return stair.getNumCards() == 0;
	}
	
	public boolean isFirstCardToInsertInFoundationFromBoardStair(int numBoardStair) {
		CardsStair cardsStair = getBoardStair(numBoardStair);
		CardsStair destCardsStair = getFoundationBySuit(cardsStair.getLastCard().getSuit());
		return destCardsStair.getNumCards() == 0;
	}
	
	public boolean isLastDiscardAceOfSuit() {
		return getLastDiscard().getNum() == SymbolsCard.ACE.getNum();
	}
	
	public boolean isLastCardOfBoardStairAseOfSuit(int numBoardStair) {
		CardsStair cardsStair = getBoardStair(numBoardStair);
		return cardsStair.getLastCard().getNum() == SymbolsCard.ACE.getNum();
	}
	
	public boolean isOneNumGreaterOfFoundationLastCard() {
		Card currentDiscard = deck.getLastDiscard();
		CardsStair foundation = getFoundationBySuit(currentDiscard.getSuit());
		Card lastStairCard = foundation.getLastCard();
		return (foundation.suit == currentDiscard.getSuit() && currentDiscard.getNum() == lastStairCard.getNum() + 1);
	}
	
	public boolean isOneNumGreaterOfFoundationLastCardFromBoardStair(int numBoardStair) {
		Card currentCard = getBoardStair(numBoardStair).getLastCard();
		CardsStair foundation = getFoundationBySuit(currentCard.getSuit());
		return (foundation.suit == currentCard.getSuit() && currentCard.getNum() == foundation.getLastCard().getNum() + 1);
	}
	
	public Card getLastCardOfFoundationFromDiscards() {
		Card currentDiscard = deck.getLastDiscard();
		CardsStair foundation = getFoundationBySuit(currentDiscard.getSuit());
		return foundation.getLastCard();
	}
	
	public Card getLastCardOfFoundationFromBoardStair(int numBoardStair) {
		Card currentCard = getBoardStair(numBoardStair).getLastCard();
		CardsStair foundation = getFoundationBySuit(currentCard.getSuit());
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
	
	public void moveFromBoardStairToFoundation(int numBoardStair) {
		ArrayList<Card> card = getBoardStair(numBoardStair).extractLastCards(1);
		CardsStair foundation = getFoundationBySuit(card.get(0).getSuit());
		foundation.addCards(card);
	}
	
	public boolean isFirstCardToInsertInBoardStair(int numBoardStair) {
		assert numBoardStair > 0;
		CardsStair cStair = getBoardStair(numBoardStair);
		return (cStair.getNumCards() == 0) || !cStair.getLastCard().getUpturned();
	}
	
	public boolean lastDiscardIsKing() {
		return getLastDiscard().getNum() == SymbolsCard.KING.getNum();
	}
	
	public boolean lastFoundationCardIsKing(int numFoundation) {
		return getFoundation(numFoundation).getLastCard().isKing();
	}
	
	public boolean lastCardOfBoardStairIsSameSuitThanLastDiscard(int numBoardStair) {
		assert numBoardStair > 0;
		Card currentDiscard = deck.getLastDiscard();
		return getBoardStair(numBoardStair).getLastCard().getSuit() == currentDiscard.getSuit();
	}
	
	public boolean lastCardOfBoardStairIsSameSuitThanLastFoundationCard(int numFoundation, int numStair) {
		assert numFoundation > 0;
		assert numStair > 0;
		return getBoardStair(numStair).getLastCard().getSuit() == getFoundation(numFoundation).getLastCard().getSuit();
	}
	
	public Card getLastCardOfBoardStair(int numBoardStair) {
		assert numBoardStair > 0;
		return getBoardStair(numBoardStair).getLastCard();
	}
	
	public boolean lastDiscardIsOneNumLessThanLastCardBoardStair(int numBoardStair){
		assert numBoardStair > 0;
		Card currentDiscard = deck.getLastDiscard();
		Card lastBoardStairCard = getBoardStair(numBoardStair).getLastCard();
		return ((lastBoardStairCard.getNum() - 1) == currentDiscard.getNum()) 
				|| !lastBoardStairCard.getUpturned();
	}
	
	public boolean lastFoundationIsOneNumLessThanLastCardBoardStair(int numFoundation, int numStair) {
		assert numFoundation > 0;
		assert numStair > 0;
		Card lastBoardStairCard = getBoardStair(numStair).getLastCard();
		return ((lastBoardStairCard.getNum() - 1) == getFoundation(numFoundation).getLastCard().getNum()) 
				|| !lastBoardStairCard.getUpturned();
	}
	
	public void moveFromDiscardsToBoardStair(int numBoardStair) {
		assert numBoardStair > 0;
		Card currentDiscard = deck.extractLastDiscard();
		CardsStair cStair = getBoardStair(numBoardStair);
		ArrayList<Card> cardsToAdd = new ArrayList<Card>();
		cardsToAdd.add(currentDiscard);
		cStair.addCards(cardsToAdd);
	}
	
	public void flipLastCardOfBoardStair(int numBoardStair) {
		assert numBoardStair > 0;
		getBoardStair(numBoardStair).getLastCard().setUpturned(true);
	}

	public boolean isBoardStairEmpty(int numBoardStair) {
		assert numBoardStair > 0;
		CardsStair cStair = getBoardStair(numBoardStair);
		return cStair.getNumCards() == 0;
	}
	
	public boolean isFoundationEmpty(int numFoundation) {
		assert numFoundation > 0;
		CardsStair cStair = getFoundation(numFoundation);
		return cStair.getNumCards() == 0;
	}

	public boolean areMoreCardsThanBoardStair(int numStair, int cardsNum) {
		assert numStair > 0;
		assert cardsNum > 0;
		CardsStair cStair = getBoardStair(numStair);
		return cStair.getNumCards() < cardsNum;
	}

	public boolean firstCardBoardStairOrigIsKing(int numBoardStair, int numCards) {
		assert numBoardStair > 0;
		assert numCards > 0;
		CardsStair cStair = getBoardStair(numBoardStair);
		return cStair.firstNCardIsKing(numCards);
	}
	
	public String getFirstNCardBoardStair(int numBoardStair, int numCards) {
		assert numBoardStair > 0;
		CardsStair cStair = getBoardStair(numBoardStair);
		return cStair.getLastNCard(numCards).toString();
	}
	
	public String getLastCardBoardStairString(int numBoardStair) {
		assert numBoardStair > 0;
		CardsStair cStair = getBoardStair(numBoardStair);
		Card lastCard = cStair.getLastCard();
		return (lastCard == null) ? cStair.toString() : lastCard.toString();
	}
	
	public boolean isFirstNCardOrigBoardStairSameSuitThanLastCardDestBoardStair(int origStair, int numCards, int destStair) {
		assert origStair > 0;
		assert destStair > 0;
		assert numCards > 0;
		CardsStair origCStair = getBoardStair(origStair);
		CardsStair destCStair = getBoardStair(destStair);
		return origCStair.getLastNCard(numCards).getSuit() == destCStair.getLastCard().getSuit();
	}
	
	public boolean isFirstNCardOrigBoardStairOneLessThanLastCardDestBoardStair(int origStair, int numCards, int destStair) {
		assert origStair > 0;
		assert destStair > 0;
		assert numCards > 0;
		CardsStair origCStair = getBoardStair(origStair);
		CardsStair destCStair = getBoardStair(destStair);
		
		return (origCStair.getLastNCard(numCards).getNum() == destCStair.getLastCard().getNum() - 1) || !destCStair.getLastCard().getUpturned();
	}
	
	public void moveFromBoardStairToBoardStair(int origStair, int destStair, int numCards) {
		assert origStair > 0;
		assert destStair > 0;
		assert numCards > 0;
		CardsStair origCStair = getBoardStair(origStair);
		CardsStair destCStair = getBoardStair(destStair);
		destCStair.addCards(origCStair.extractLastCards(numCards));
	}

	public void moveFromFoundationToBoardStair(int numFoundation, int destStair) {
		assert numFoundation > 0;
		assert destStair > 0;
		CardsStair origCStair = getFoundation(numFoundation);
		CardsStair destCStair = getBoardStair(destStair);
		destCStair.addCards(origCStair.extractLastCards(1));
	}
	
}
