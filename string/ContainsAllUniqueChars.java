/** 
 * This class tests whether a string consists of all unique characters
 * 
 * @author anupkhadka
 */

package string;

import java.lang.String;

public class ContainsAllUniqueChars {

	public static boolean containsAllUniqueChars(String str) {
		final int TOTAL_ASCII_CHARS = 256;

		if(str.length() > TOTAL_ASCII_CHARS) {
			//there are only 256 ASCII characters.
			//if the string length > 256, that means, at least
			//one of the ASCII characters got repeated
			return false;
		}

		boolean [] charSet = new boolean[TOTAL_ASCII_CHARS];

		for(int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			if(charSet[index]) {
				//this character has already been found before
				return false;
			}
			charSet[index] = true;
		}

		return true;
	}

	/**
 	 * @param args
	 */
	public static void main(String [] args) {
		String str1, str2;
		str1 = "abcdefijgh";
		str2 = "abcdefiagh";
		if(containsAllUniqueChars(str1)) {
			System.out.println(str1+" contains all unique characters - correct!");
		}

		if(containsAllUniqueChars(str2)) {
			System.out.println(str2+" contains all unique characters - incorrect!");
		}

	}
}
