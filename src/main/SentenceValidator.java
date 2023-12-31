package main;

public class SentenceValidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// using a ternary operator in place of an if-else statement to make code easier to understand
		System.out.println(validSentence("The quick brown fox said “hello Mr lazy dog”.")? "Valid Sentence":"Invalid Sentence");
		System.out.println(validSentence("The quick brown fox said hello Mr lazy dog.")? "Valid Sentence":"Invalid Sentence");
		System.out.println(validSentence("One lazy dog is too few, 13 is too many.")? "Valid Sentence":"Invalid Sentence");
		System.out.println(validSentence("One lazy dog is too few, thirteen is too many.")? "Valid Sentence":"Invalid Sentence");
		System.out.println(validSentence("How many \"lazy dogs\" are there?")? "Valid Sentence":"Invalid Sentence");
		
		
		System.out.println(validSentence("The quick brown fox said \"hello Mr. lazy dog\".")? "Valid Sentence":"Invalid Sentence");
		System.out.println(validSentence("the quick brown fox said “hello Mr lazy dog\".")? "Valid Sentence":"Invalid Sentence");
		System.out.println(validSentence("\"The quick brown fox said “hello Mr lazy dog.\"")? "Valid Sentence":"Invalid Sentence");
		System.out.println(validSentence("One lazy dog is too few, 12 is too many.")? "Valid Sentence":"Invalid Sentence");
		System.out.println(validSentence("Are there 11, 12, or 13 lazy dogs?")? "Valid Sentence":"Invalid Sentence");
		System.out.println(validSentence("There is no punctuation in this sentence")? "Valid Sentence":"Invalid Sentence");
		
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
				if (digitCheck >= 0 && digitCheck < 13) { 
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

		//if the quoteCounter divides into two and the first Character is upper then it will return true Also.
		// Also making sure that the array of words is greater than one.
		return quoteCounter % 2 == 0 && Character.isUpperCase(sentence.charAt(0)) && mys.length>1;
	}
}
