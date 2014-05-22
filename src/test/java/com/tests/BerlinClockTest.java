package com.tests;

import org.junit.Assert;
import org.junit.Test;

import berlin.clock.BerlinClock;
import berlin.clock.BerlinClockBuilder;

public class BerlinClockTest {
	

	
	private static final String VALID_TIME_1 = "13:17:01";
	private static final Integer[] VALID_TIME_RTRN_1 = {13, 17, 1};
	
	private static final String VALID_TIME_2 = "23:59:59";
	private static final Integer[] VALID_TIME_RTRN_2 = {23, 59, 59};
	
	private static final String VALID_TIME_3 = "24:00:00";
	private static final Integer[] VALID_TIME_RTRN_3 = {24, 00, 00};
	
	private static final String INVALID_HOUR_FMT = "30:12:12";
	private static final String INVALID_MINUTE_FMT = "12:60:12";
	private static final String INVALID_SECOND_FMT = "12:12:60";
	private static final Integer[] FAILS_REGEX_RTRN = {null, null, null};
	
	private static final String INVALID_HRS_VALUE = "25:17:01";
	private static final Integer[] INVALID_HRS_RTRN = {null, 17, 01};
	
	private static final String INVALID_MIN_VALUE = "13:60:01";
	private static final Integer[] INVALID_MIN_RTRN = {null, null, null};
	
	private static final String INVALID_SEC_VALUE = "13:17:60";
	private static final Integer[] INVALID_SEC_RTRN= {null, null, null};
	
	
	
	
	@Test
	public void testParse_hhmmss() {
		Assert.assertArrayEquals(VALID_TIME_RTRN_1, BerlinClockBuilder.parse(VALID_TIME_1));
		Assert.assertArrayEquals(VALID_TIME_RTRN_2, BerlinClockBuilder.parse(VALID_TIME_2));
		Assert.assertArrayEquals(VALID_TIME_RTRN_3, BerlinClockBuilder.parse(VALID_TIME_3));
		
		Assert.assertArrayEquals(FAILS_REGEX_RTRN, BerlinClockBuilder.parse(INVALID_HOUR_FMT));
		Assert.assertArrayEquals(FAILS_REGEX_RTRN, BerlinClockBuilder.parse(INVALID_MINUTE_FMT));
		Assert.assertArrayEquals(FAILS_REGEX_RTRN, BerlinClockBuilder.parse(INVALID_SECOND_FMT));
		
		Assert.assertArrayEquals(INVALID_HRS_RTRN, BerlinClockBuilder.parse(INVALID_HRS_VALUE));

		Assert.assertArrayEquals(INVALID_MIN_RTRN, BerlinClockBuilder.parse(INVALID_MIN_VALUE));
		
		Assert.assertArrayEquals(INVALID_SEC_RTRN, BerlinClockBuilder.parse(INVALID_SEC_VALUE));
	}
	
	@Test
	public void testBerlinSeconds() {
		Assert.assertEquals(1, BerlinClockBuilder.getSeconds(0));
		Assert.assertEquals(0, BerlinClockBuilder.getSeconds(59));
	}
	
	@Test
	public void testBerlinTimeString() {
		BerlinClock expected1 = new BerlinClock(VALID_TIME_1, "RROO", "RRRO", "YYROOOOOOOO", "YYOO", "O");
		BerlinClock expected2 = new BerlinClock(VALID_TIME_2, "RRRR", "RRRO", "YYRYYRYYRYY", "YYYY", "O");
		BerlinClock expected3 = new BerlinClock(VALID_TIME_3, "RRRR", "RRRR", "OOOOOOOOOOO", "OOOO", "Y");
		
		Assert.assertEquals(expected1.toString(), BerlinClockBuilder.build(VALID_TIME_1).toString());
		Assert.assertEquals(expected2.toString(), BerlinClockBuilder.build(VALID_TIME_2).toString());
		Assert.assertEquals(expected3.toString(), BerlinClockBuilder.build(VALID_TIME_3).toString());
	}
}
