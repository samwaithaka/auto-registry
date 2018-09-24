package com.vehicle.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class contains methods that take in String and carry out processing 
 * using Regex and other string processing approaches
 * @author Samuel
 *
 */
public class StringProcessor {
	
	/**
	 * Method returns comma separated list of plate numbers that are in the provided string
	 * @param text
	 * @return plate
	 */
	public static String plateNumberExtractor(String text) {
		String patternString = "[Kk][a-zA-Z]{2}[0-9]{3}[a-zA-Z]";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text);
		String plate = "";
		while (matcher.find()) {
			//The condition is for separating plates by comma, if more than one
			plate += (plate == "" ? "" : ",") + matcher.group();
		}
		return plate;
	}
}
