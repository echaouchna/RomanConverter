package fr.ineat;

import java.util.LinkedHashMap;
import java.util.Map;

public final class RomanConverterUtil {
	
	private static final Map<String, Integer> romanNumerals;
	
	private RomanConverterUtil() {
	}

	public static String getRomanNumber(int intEntry) throws NumberOutOfRangeException {
		if (intEntry < 1 || intEntry >= 4000) {
			throw new NumberOutOfRangeException("Number " + intEntry + " is out of range (1, 3999)");
		}

		String result = "";
		for (Map.Entry<String, Integer> entry : romanNumerals.entrySet()) {
			int repeatTimes = intEntry / entry.getValue();
			result += generateNumerals(entry.getKey(), repeatTimes);
			intEntry = intEntry % entry.getValue();
		}
		return result;
	}
	
	public static String getRomanNumber(String stringIntEntry) throws NumberFormatException, NumberOutOfRangeException {
		return getRomanNumber(Integer.parseInt(stringIntEntry));
	}

	private static String generateNumerals(String str, int times) {
		if (str == null) {
			return "";
		}
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < times; i++) {
			sb.append(str);
		}
		return sb.toString();
	}
	
	static {
		romanNumerals = new LinkedHashMap<String, Integer>();
		
		romanNumerals.put("M", 1000);
		romanNumerals.put("CM", 900);
		romanNumerals.put("D", 500);
		romanNumerals.put("CD", 400);
		romanNumerals.put("C", 100);
		romanNumerals.put("XC", 90);
		romanNumerals.put("L", 50);
		romanNumerals.put("XL", 40);
		romanNumerals.put("X", 10);
		romanNumerals.put("IX", 9);
		romanNumerals.put("V", 5);
		romanNumerals.put("IV", 4);
		romanNumerals.put("I", 1);
	}

}
