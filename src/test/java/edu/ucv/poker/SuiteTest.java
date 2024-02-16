package edu.ucv.poker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ucv.poker.Suite;

public class SuiteTest {

	@Test
	public void nextTest() {
		assertEquals(Suite.DIAMANTES.next(2), Suite.TREBOLES);
		assertEquals(Suite.CORAZONES.next(6), Suite.PICAS);
	}

}
