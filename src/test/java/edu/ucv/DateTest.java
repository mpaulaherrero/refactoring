package edu.ucv;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DateTest {
    @Test
    public void testDateWithGreaterThanDayLeapYearError(){
		assertFalse(new Date(29,2,1900).validate());
	}

    @Test
    public void testDateWithGreaterThanDayLogMonthError(){
		assertFalse(new Date(32,11,2000).validate());
	}

    @Test
    public void testDateWithGreaterThanDayShortMonthError(){
		assertFalse(new Date(31,4,2000).validate());
	}

    @Test
	public void testDateWithLessThanDayError(){
		assertFalse(new Date(0,2,2011).validate());
	}

	@Test
    public void testDateWithGreaterThanMonthError(){
		assertFalse(new Date(14,13,2016).validate());
	}

	@Test
	public void testDateWithLessThanMonthError(){
		assertFalse(new Date(14,0,2016).validate());
	}

    @Test
    public void testDateValidLessDay(){
		assertTrue(new Date(1,1,2016).validate());
	}

    @Test
    public void testDateValidLeapYear(){
        assertTrue(new Date(29,2,2024).validate());
	}

    @Test
    public void testDateValidLogMonth(){
		assertTrue(new Date(31,12,2024).validate());
	}

    @Test
    public void testDateValidShortMonth(){
		assertTrue(new Date(30,4,2016).validate());
	}
}
