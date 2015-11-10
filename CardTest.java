package javaPoker;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void testCardConstructor() {
		Card c;
		c = new Card(4, "Hearts");
		assertEquals(4,c.getNumber());
		assertEquals("Hearts", c.getSuit());
	}
}
