package es.upm.miw.klondikedga;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Card;
import model.Deck;
import model.Suit;

public class DeckTest {

	Deck deck;
	
	@Before
	public void before() {
		deck = new Deck();
	}
	
	@Test
	public void testDeck() {
		for(int i = 1; i <= deck.getCardsPerSuit(); i++) {
			assertEquals(new Card(i, Suit.COINS, false).toString(), deck.getCards().get(i - 1).toString());
		}
		for(int i = 1; i <= deck.getCardsPerSuit(); i++) {
			assertEquals(new Card(i, Suit.SWORDS, false).toString(), deck.getCards().get(i+13 - 1).toString());
		}
		for(int i = 1; i <= deck.getCardsPerSuit(); i++) {
			assertEquals(new Card(i, Suit.BASTOS, false).toString(), deck.getCards().get(i+26 - 1).toString());
		}
		for(int i = 1; i <= deck.getCardsPerSuit(); i++) {
			assertEquals(new Card(i, Suit.CUPS, false).toString(), deck.getCards().get(i+39 - 1).toString());
		}
	
	}

}
