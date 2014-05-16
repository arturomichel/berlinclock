package com.tests;

import org.junit.Assert;
import org.junit.Test;

import berlin.clock.BerlinHeuer;
import berlin.clock.BerlinHeuerParser;

public class BerlinHeuerConverterTest {
	

	
	private static String VALID_TIME_1 = "13:17:01";
	private static Integer[] VALID_TIME_RTRN_1 = {13,17,1};
	
	private static String VALID_TIME_2 = "23:59:59";
	private static Integer[] VALID_TIME_RTRN_2 = {23,59,59};
	
	private static String VALID_TIME_3 = "24:00:00";
	private static Integer[] VALID_TIME_RTRN_3 = {24,00,00};
	
	private static String INVALID_FMT_1 = "1:12:12";
	private static String INVALID_FMT_2 = "12:1:12";
	private static String INVALID_FMT_3 = "12:12:1";
	private static Integer[] INVALID_FMT_RTRN = {null,null,null};
	
	private static String INVALID_HRS_VALUE = "25:17:01";
	private static Integer[] INVALID_HRS_RTRN = {null,17,01};
	
	private static String INVALID_MIN_VALUE = "13:60:01";
	private static Integer[] INVALID_MIN_RTRN = {null,null,null};
	
	private static String INVALID_SEC_VALUE = "13:17:60";
	private static Integer[] INVALID_SEC_RTRN= {null,null,null};
	
	
	
	
	@Test
	public void testParse_hhmmss() {
		Assert.assertArrayEquals(VALID_TIME_RTRN_1, BerlinHeuerParser.parse(VALID_TIME_1));
		Assert.assertArrayEquals(VALID_TIME_RTRN_2, BerlinHeuerParser.parse(VALID_TIME_2));
		Assert.assertArrayEquals(VALID_TIME_RTRN_3, BerlinHeuerParser.parse(VALID_TIME_3));
		
		Assert.assertArrayEquals(INVALID_FMT_RTRN, BerlinHeuerParser.parse(INVALID_FMT_1));
		Assert.assertArrayEquals(INVALID_FMT_RTRN, BerlinHeuerParser.parse(INVALID_FMT_2));
		Assert.assertArrayEquals(INVALID_FMT_RTRN, BerlinHeuerParser.parse(INVALID_FMT_3));
		
		Assert.assertArrayEquals(INVALID_HRS_RTRN, BerlinHeuerParser.parse(INVALID_HRS_VALUE));

		Assert.assertArrayEquals(INVALID_MIN_RTRN, BerlinHeuerParser.parse(INVALID_MIN_VALUE));
		
		Assert.assertArrayEquals(INVALID_SEC_RTRN, BerlinHeuerParser.parse(INVALID_SEC_VALUE));
	}
	
	@Test
	public void testBerlinSeconds() {
		Assert.assertEquals(1, BerlinHeuerParser.getSeconds(0));
		Assert.assertEquals(0, BerlinHeuerParser.getSeconds(59));
	}
	
	@Test
	public void testBerlinTimeString(){
		BerlinHeuer expected1 = new BerlinHeuer(VALID_TIME_1, "O RROO RRRO YYROOOOOOOO YYOO", false);
		BerlinHeuer expected2 = new BerlinHeuer(VALID_TIME_2, "O RRRR RRRO YYRYYRYYRYY YYYY", false);
		BerlinHeuer expected3 = new BerlinHeuer(VALID_TIME_3, "Y RRRR RRRR OOOOOOOOOOO OOOO", false);
		
		Assert.assertEquals(expected1.toString(), BerlinHeuerParser.toBerlinString(VALID_TIME_1).toString());
		Assert.assertEquals(expected2.toString(), BerlinHeuerParser.toBerlinString(VALID_TIME_2).toString());
		Assert.assertEquals(expected3.toString(), BerlinHeuerParser.toBerlinString(VALID_TIME_3).toString());
	}
}
