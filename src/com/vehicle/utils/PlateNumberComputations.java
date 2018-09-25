package com.vehicle.utils;

import java.util.stream.IntStream;

/**
 * This class contains different computations involving vehicle registration plate numbers
 * @author samuel
 *
 */
public class PlateNumberComputations {
	/**
	 * The method takes in 2 plate numbers and calculates registration events between them
	 * @param plateA
	 * @param plateB
	 * @return difference
	 */
	public static int findPlateNumberDifference(String plateA, String plateB) {
		String newer = null,older = null;
		int difference = 0;
		// Determine the newer plate number before counting the difference
		if(reorderForComparison(plateA).compareTo(reorderForComparison(plateB)) > 0) {
			newer = plateA;
			older = plateB;
		} else if (reorderForComparison(plateA).compareTo(reorderForComparison(plateB)) < 0) {
			newer = plateB;
			older = plateA;
		}
		if(newer == null || older == null)
			return difference;
		while(!older.equalsIgnoreCase(newer)) {
			older = incrementPlateNumber(older);
			difference++;
		}
		return difference;
	}

	/**
	 * This method increments string, say from A to B
	 * @return
	 */
	public static String incrementString(String letter) {
		String alphas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] letters = alphas.toCharArray();
		int charIndex =
				IntStream.range(0, letters.length)
				.filter(i -> letters[i] == letter.charAt(0))
				.findFirst()
				.orElse(-1);
		int nextCharIndex = 0;
		if(charIndex == 25)
			nextCharIndex = 0;
		else
			nextCharIndex = charIndex + 1;
		String nextChar = Character.toString(letters[nextCharIndex]);
		return nextChar;
	}

	/**
	 * This method increments 2 letter string sequencially, say from AB to AC, BZ to CA and so on
	 * @param doubleLetters
	 * @return
	 */
	public static String incrementDoubleLetters(String doubleLetters) {
		String result = null;
		if(doubleLetters.length() == 2) {
			String letter1 = doubleLetters.substring(0, 1);
			String letter2 = doubleLetters.substring(1, 2);
			letter2 = incrementString(letter2);
			if(letter2.equalsIgnoreCase("A"))
				letter1 = incrementString(letter1);
			result = letter1+letter2;
		}
		return result;
	}

	/**
	 * This method takes a vehicles registration plate number and increments by one unit value
	 * @param plateNumber
	 * @return
	 */
	public static String incrementPlateNumber(String plateNumber) {
		// Split plate number into 3 for instance, KBU873K will be split into BU(x),873(y) and K(z)
		String x = plateNumber.substring(1, 3);
		int y = Integer.parseInt(plateNumber.substring(3,6));
		String z = plateNumber.substring(6,7);
		y++;
		if(y == 1000) {
			y = 0;
			z = incrementString(z);
			if(z.equalsIgnoreCase("A")) {
				x = incrementDoubleLetters(x);
			}
		}
		String yString = String.format("%03d",y);
		return "K" + x + yString + z;
	}

	/**
	 * This method reorders the plate number, for proper comparison, since the; the platenumber has 
	 * 4 parts, starting with the 3 digits, then the last one letter, and lastly the 2 letters after the 
	 * letter 'K'. Comparison string has to be in that format
	 * @return
	 */
	public static String reorderForComparison(String plateNumber) {
		String x = plateNumber.substring(0,3);
		int y = Integer.parseInt(plateNumber.substring(3,6));
		String z = plateNumber.substring(6,7);
		String yString = String.format("%03d",y);
		return x + z + yString;
	}
}
