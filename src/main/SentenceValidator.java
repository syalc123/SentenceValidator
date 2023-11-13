package main;

public class SentenceValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "Are there 11, 12, or 13, lazy dogs?";
		System.out.println(validSentence(s));
	}

	public static boolean validSentence(String sentence) {
		int quoteCounter = 0; // variable to keep track of all quotation marks
		int digitCheck = 0; // variable to keep track of any digits in the sentence
		String[] mys = sentence.split(" "); // Splitting the string into individual words so we can check for digits

		// checking that the final element in the string is punctuation
		switch (sentence.charAt(sentence.length() - 1)) {
		case '.':
			break;
		case '?':
			break;
		case '!':
			break;
		default:
			return false; // returns false if no punctuation at the end of the string.
		}

		// check to ensure that any number below 13 are spelled out.
		for (String word : mys) {
			word = word.replaceAll("\\p{Punct}", ""); // regEx removes punctuation and replaces with a white space
			word.trim(); // removes white space added from operation above, if punctuation found as this affects parsing.
			
			try { // try catch as we may be parsing words. Prevents program from crashing
				digitCheck = Integer.parseInt(word); // parses word to digit
				if (digitCheck >= 0 && digitCheck <= 13) { 
					return false; // if digit greater than 0 but less than 13 return false as it needed to be typed out
				}
			} catch (Exception ex) {// catch exception if thrown
				
			}

		}

		//check to ensure that string doesn't contain a . and all " are closed off.
		for (int i = 1; i < sentence.length() - 2; i++) {

			if (sentence.charAt(i) == '"') {
				quoteCounter++; // increment quote counter
			}
			if (sentence.charAt(i) == '.') {
				return false; // if found exits out of loop returning false
			}
		}

		//if the quoteCounter divides into two and the first Character is upper then it will return true. 
		return quoteCounter % 2 == 0 && Character.isUpperCase(sentence.charAt(0));
	}
}
