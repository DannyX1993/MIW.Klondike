package es.upm.miw.klondikedga.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> cards;
	
	private ArrayList<Card> discards;
	
	private static final int TOTAL_CARDS = 52;
	
	public static final int CARDS_PER_SUIT = TOTAL_CARDS / Suit.NUM_SUITS;
	
	public Deck() {
		cards = new ArrayList<Card>(TOTAL_CARDS);
		discards = new ArrayList<Card>();
	}
	
	public ArrayList<Card> getDiscards() {
		return discards;
	}
	
	public void initCards() {
		setCardsOfSuit(Suit.COINS);
		setCardsOfSuit(Suit.SWORDS);
		setCardsOfSuit(Suit.BASTOS);
		setCardsOfSuit(Suit.CUPS);
	}
	
	private void setCardsOfSuit(Suit suit) {
		assert suit != null;
		for(int i = 1; i <= CARDS_PER_SUIT; i++) {
			cards.add(new Card(i, suit, false));
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public int getNumCards() {
		return cards.size();
	}
	
	public int getNumDiscards() {
		return discards.size();
	}
	
	public Card getLastDiscard() {
		return discards.get(getNumDiscards() - 1);
	}
	
	public Card extractLastDiscard() {
		Card nextCard = getLastDiscard();
		discards.remove(getNumDiscards() - 1);
		return nextCard;
	}
	
	public int getCardsPerSuit() {
		return CARDS_PER_SUIT;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	public ArrayList<Card> getGroupOfCards(int upturnedCardsNum, int facedownCardsNum) {
		ArrayList<Card> groupedCards = new ArrayList<Card>(upturnedCardsNum + facedownCardsNum);
		for(int i = 0, upturnedCount = 0, facedownCount = 0; i < (upturnedCardsNum + facedownCardsNum); i++) {
			if(facedownCount < facedownCardsNum) {
				groupedCards.add(this.extractNextCard());
				facedownCount++;
			} else if(upturnedCount < upturnedCardsNum) {
				Card nextCard = this.extractNextCard();
				nextCard.setUpturned(true);
				groupedCards.add(nextCard);
				upturnedCount++;
			}
		}
		return groupedCards;
	}
	
	public void moveNextCardsToDiscards(int numCards) {
		assert numCards > 0;
		assert numCards <= getNumCards();
		for(Card card : getFlippedCards(numCards)) {
			discards.add(card);
		}
	}
	
	private ArrayList<Card> getFlippedCards(int numCards) {
		ArrayList<Card> cardsToDiscards = new ArrayList<Card>(numCards);
		for(int i = 0; i < numCards; i++) {
			Card card = extractNextCard();
			card.setUpturned(true);
			cardsToDiscards.add(card);
		}
		return cardsToDiscards;
	}
	
	private Card extractNextCard() {
		Card nextCard = cards.get(getNumCards() - 1);
		cards.remove(getNumCards() - 1);
		return nextCard;
	}
	
	public void moveAllDiscardsToDeck() {
		for(int i = getNumDiscards() - 1; i >= 0; i--) {
			Card currentCard = discards.get(i);
			discards.remove(i);
			cards.add(currentCard);
		}
	}
	
}
