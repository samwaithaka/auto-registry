package com.vehicle.utils;

import java.util.ArrayList;
import java.util.List;
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
	public static List<String> extractPlateNumber(String text) {
		String patternString = "[Kk][a-zA-Z]{2}[0-9]{3}[a-zA-Z]";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text);
		List<String> plates = new ArrayList<String>();
		while (matcher.find()) {
			plates.add(matcher.group());
		}
		return plates;
	}
}
