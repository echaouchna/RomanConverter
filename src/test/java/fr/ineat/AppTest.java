package fr.ineat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class AppTest {
	
	private static Logger logger = LogManager.getLogger(AppTest.class);
	/**
	 * compare the list given in the exercise with the results from the conversion method
	 */
	@Test
	public void testApp() {
		List<String> expectedList = Arrays.asList("CLIII", "CCXLIX", "DLXXXIII", "MCMLXIII", "MMMDCCCLXXV");
		List<String> actualList = null;
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("input.txt").getFile());
		try {
			actualList = App.readAndConvertFile(file);
		} catch (IOException e) {
			logger.error("Unable to open input file");
		}
		
		Assert.assertEquals(expectedList, actualList);
	}
	
	/**
	 * compare the first 1000 Roman numbers with the conversion of the first 1000 integers
	 * @throws NumberOutOfRangeException
	 * @throws FileNotFoundException
	 */
	@Test
	public void test1To1000() throws NumberOutOfRangeException, FileNotFoundException {
		List<String> expectedList = new ArrayList<String>();
		List<String> actualList = new ArrayList<String>();
		
		ClassLoader classLoader = getClass().getClassLoader();
		Scanner s = new Scanner(new File(classLoader.getResource("roman_1_to_1000.txt").getFile()));
		while (s.hasNext()){
			String line = s.nextLine();
			expectedList.add(line);
		}
		s.close();
		
		for (int i = 1; i <= 1000; i++) {
			actualList.add(RomanConverterUtil.getRomanNumber(i));
		}
		
		Assert.assertEquals(expectedList, actualList);
	}
}
