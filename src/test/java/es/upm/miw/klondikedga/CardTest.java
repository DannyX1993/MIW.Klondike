package es.upm.miw.klondikedga;

import static org.junit.Assert.*;

import org.junit.Test;

import es.upm.miw.klondikedga.models.Card;
import es.upm.miw.klondikedga.models.Suit;

public class CardTest {
	
	Card card;

	@Test
	public void testCard() {
		/*card = new Card(1, Suit.BASTOS, true);
		assertEquals(1, card.getNum());
		assertEquals(Suit.BASTOS, card.getSuit());
		assertTrue(card.getUpturned());*/
	}

	@Test
	public void testSetNum() {
		card = new Card(2, Suit.CUPS, true);
		card.setNum(3);
		assertEquals(3, card.getNum());
	}

	@Test
	public void testGetNum() {
		card = new Card(2, Suit.CUPS, true);
		assertEquals(2, card.getNum());
		
		card = new Card(1, Suit.CUPS, true);
		assertEquals(1, card.getNum());
	}

	@Test
	public void testSetSuit() {
		card = new Card(2, Suit.BASTOS, true);
		assertTrue(card.getUpturned());
	}

	@Test
	public void testGetSuit() {
		card = new Card(2, Suit.BASTOS, true);
		assertEquals(Suit.BASTOS, card.getSuit());
		
		card = new Card(2, Suit.COINS, true);
		assertEquals(Suit.COINS, card.getSuit());
		
		card = new Card(2, Suit.CUPS, true);
		assertEquals(Suit.CUPS, card.getSuit());
		
		card = new Card(2, Suit.SWORDS, true);
		assertEquals(Suit.SWORDS, card.getSuit());
	}

	@Test
	public void testSetUpturned() {
		card = new Card(2, Suit.BASTOS, true);
		card.setUpturned(true);
		assertTrue(card.getUpturned());
		
		card = new Card(2, Suit.BASTOS, true);
		card.setUpturned(false);
		assertFalse(card.getUpturned());
	}

	@Test
	public void testGetUpturned() {
		card = new Card(2, Suit.BASTOS, true);
		assertTrue(card.getUpturned());
		
		card = new Card(2, Suit.BASTOS, false);
		assertFalse(card.getUpturned());
	}

	@Test
	public void testIsKing() {
		card = new Card(13, Suit.BASTOS, true);
		assertTrue(card.isKing());
		
		card = new Card(2, Suit.COINS, true);
		assertFalse(card.isKing());
	}

	@Test
	public void testIsQueen() {
		card = new Card(12, Suit.BASTOS, true);
		assertTrue(card.isQueen());
		
		card = new Card(3, Suit.COINS, true);
		assertFalse(card.isQueen());
	}
	
	@Test
	public void testIsJack() {
		card = new Card(11, Suit.BASTOS, true);
		assertTrue(card.isJack());
		
		card = new Card(3, Suit.COINS, true);
		assertFalse(card.isJack());
	}
	
	@Test
	public void testIsAce() {
		card = new Card(1, Suit.BASTOS, true);
		assertTrue(card.isAce());
		
		card = new Card(2, Suit.COINS, true);
		assertFalse(card.isAce());
	}

	@Test
	public void testToString() {
		card = new Card(1, Suit.BASTOS, true);
		assertEquals("[A,b]", card.toString());
		card = new Card(1, Suit.COINS, true);
		assertEquals("[A,o]", card.toString());
		card = new Card(1, Suit.SWORDS, true);
		assertEquals("[A,e]", card.toString());
		card = new Card(1, Suit.CUPS, true);
		assertEquals("[A,c]", card.toString());
		
		card = new Card(11, Suit.BASTOS, true);
		assertEquals("[J,b]", card.toString());
		card = new Card(11, Suit.COINS, true);
		assertEquals("[J,o]", card.toString());
		card = new Card(11, Suit.SWORDS, true);
		assertEquals("[J,e]", card.toString());
		card = new Card(11, Suit.CUPS, true);
		assertEquals("[J,c]", card.toString());
		
		card = new Card(12, Suit.BASTOS, true);
		assertEquals("[Q,b]", card.toString());
		card = new Card(12, Suit.COINS, true);
		assertEquals("[Q,o]", card.toString());
		card = new Card(12, Suit.SWORDS, true);
		assertEquals("[Q,e]", card.toString());
		card = new Card(12, Suit.CUPS, true);
		assertEquals("[Q,c]", card.toString());
		
		card = new Card(13, Suit.BASTOS, true);
		assertEquals("[K,b]", card.toString());
		card = new Card(13, Suit.COINS, true);
		assertEquals("[K,o]", card.toString());
		card = new Card(13, Suit.SWORDS, true);
		assertEquals("[K,e]", card.toString());
		card = new Card(13, Suit.CUPS, true);
		assertEquals("[K,c]", card.toString());
		
		card = new Card(2, Suit.BASTOS, true);
		assertEquals("[2,b]", card.toString());
		card = new Card(2, Suit.COINS, true);
		assertEquals("[2,o]", card.toString());
		card = new Card(2, Suit.SWORDS, true);
		assertEquals("[2,e]", card.toString());
		card = new Card(2, Suit.CUPS, true);
		assertEquals("[2,c]", card.toString());
	
	}

}
