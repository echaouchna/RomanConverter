package fr.ineat;

import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {
	
	/**
	 * Test whether, for numbers in the correct range, the result are correct or not
	 * @throws NumberOutOfRangeException
	 */
	@Test
	public void testConvertor() throws NumberOutOfRangeException {
		/*
		 * (153, CLIII)
		 * (249, CCXLIX)
		 * (583, DLXXXIII,)
		 * (1963, MCMLXIII)
		 * (3875, MMMDCCCLXXV)
		 */
		
		Assert.assertEquals(RomanConverterUtil.getRomanNumber(153), "CLIII");
		Assert.assertEquals(RomanConverterUtil.getRomanNumber(249), "CCXLIX");
		Assert.assertEquals(RomanConverterUtil.getRomanNumber(583), "DLXXXIII");
		Assert.assertEquals(RomanConverterUtil.getRomanNumber(1963), "MCMLXIII");
		Assert.assertEquals(RomanConverterUtil.getRomanNumber(3875), "MMMDCCCLXXV");
		
		Assert.assertEquals(RomanConverterUtil.getRomanNumber("153"), "CLIII");
		Assert.assertEquals(RomanConverterUtil.getRomanNumber("249"), "CCXLIX");
		Assert.assertEquals(RomanConverterUtil.getRomanNumber("583"), "DLXXXIII");
		Assert.assertEquals(RomanConverterUtil.getRomanNumber("1963"), "MCMLXIII");
		Assert.assertEquals(RomanConverterUtil.getRomanNumber("3875"), "MMMDCCCLXXV");
	}
	
	/**
	 * test whether for non a number value the getRomanNumber throws NumberFormatException
	 * @throws NumberFormatException
	 * @throws NumberOutOfRangeException
	 */
	@Test(expected=NumberFormatException.class)
	public void testNonNumberFormat() throws NumberFormatException, NumberOutOfRangeException {
		RomanConverterUtil.getRomanNumber("3875v");
	}
	
	/**
	 * check if for an empty value the getRomanNumber throws NumberFormatException
	 * @throws NumberFormatException
	 * @throws NumberOutOfRangeException
	 */
	@Test(expected=NumberFormatException.class)
	public void testEmpty() throws NumberFormatException, NumberOutOfRangeException {
		RomanConverterUtil.getRomanNumber("");
	}
	
	/**
	 * check if for a real value the getRomanNumber throws NumberFormatException
	 * @throws NumberFormatException
	 * @throws NumberOutOfRangeException
	 */
	@Test(expected=NumberFormatException.class)
	public void testRealNumber() throws NumberFormatException, NumberOutOfRangeException {
		RomanConverterUtil.getRomanNumber("4.2");
	}
	
	/**
	 * check if for an out of range value the getRomanNumber throws NumberOutOfRangeException
	 * @throws NumberOutOfRangeException
	 */
	@Test(expected=NumberOutOfRangeException.class)
	public void testOutOfRange() throws NumberOutOfRangeException {
		RomanConverterUtil.getRomanNumber(5000);
	}
	
	/**
	 * check if for a negative value the getRomanNumber throws NumberOutOfRangeException
	 * @throws NumberOutOfRangeException
	 */
	@Test(expected=NumberOutOfRangeException.class)
	public void testNegativeNumber() throws NumberOutOfRangeException {
		RomanConverterUtil.getRomanNumber(-1);
	}
	
	/**
	 * check if for zero the getRomanNumber throws NumberOutOfRangeException
	 * @throws NumberOutOfRangeException
	 */
	@Test(expected=NumberOutOfRangeException.class)
	public void testZero() throws NumberOutOfRangeException {
		RomanConverterUtil.getRomanNumber(0);
	}

}
