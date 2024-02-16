package edu.ucv.poker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.ucv.poker.Value;

public class ValueTest {

	@Test
	public void greaterTest() {
		for (int i = 0; i < Value.values().length; i++) {
			for (int j = 0; j < Value.values().length; j++) {
				if (j < i) {
					assertTrue(Value.values()[i].greater(Value.values()[j]));
				} else {
					assertFalse(Value.values()[i].greater(Value.values()[j]));
				}
			}
		}
	}
	
	@Test
	public void nextTest() {
		assertEquals(Value.TRES.next(6), Value.NUEVE);
		assertEquals(Value.INFANTE.next(4), Value.DOS);
	}

}
