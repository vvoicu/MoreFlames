package com.tools.utils;

public class FormatterUtils {

	/**
	 * adds decimal point to a string.The decimals parameter tells how many
	 * digits remain after the decimal point
	 * 
	 * @param value
	 * @param decimals
	 * @return
	 */
	public static String parseValue(String value, int decimals) {
		String cleanValue = getIntegerNumberFromString(value);
		StringBuilder builder = new StringBuilder(cleanValue);
		if (decimals != 0)
			builder.insert(builder.length() - decimals, ".");

		return String.valueOf(builder);
	}

	public static String getIntegerNumberFromString(String s) {
		StringBuilder t = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				t.append(ch);
			}
		}
		return String.valueOf(t);
	}
}
