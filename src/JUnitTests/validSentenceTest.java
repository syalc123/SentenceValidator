package JUnitTests;

import main.SentenceValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class validSentenceTest {

	String testValue; // values to be used during tests
	boolean testResult; // result of method call

	// Given that the first letter is capital but all other conditions are met. Then
	// return false
	@Test
	void testFirstLetterCapital() {
		testValue = "first one \"\" sentence.";
		testResult = SentenceValidator.validSentence(testValue);
		assertEquals(testResult, false);

	}

	// Given that the last letter is not punctuation but all other conditions = true
	// Then return false
	@Test
	void testLastCharPunctuation() {
		testValue = "Second two \"\" sentence";
		testResult = SentenceValidator.validSentence(testValue);
		assertEquals(testResult, false);
	}

	// Given that their are unclosed quotations. But all other conditions are met
	// Then return false
	@Test
	void testUnclosedQuotes() {
		testValue = "Second two \" sentence.";
		testResult = SentenceValidator.validSentence(testValue);
		assertEquals(testResult, false);
	}

	// Given that a negative number is entered quotations. But all other conditions
	// are met
	// Then return false
	@Test
	void testNegativeNumberEntered() {
		testValue = "Second -9 \"\"sentence.";
		testResult = SentenceValidator.validSentence(testValue);
		assertEquals(testResult, false);
	}

	// Given that an integer less than 13 is a digit and not typed But all other
	// conditions are met
	// Then return false
	@Test
	void testIntegerLessThan13() {
		testValue = "Second 12 \"\" sentence.";
		testResult = SentenceValidator.validSentence(testValue);
		assertEquals(testResult, false);
	}

	//Given an integer less than 13 is typed. Then return true
	@Test
	void testIntegerLessThan13Typed() {
		testValue = "Second one \"\" sentence.";
		testResult = SentenceValidator.validSentence(testValue);
		assertEquals(testResult, true);
	}

	//Given an integer greater than 14 is typed as a digit. Then return true.
	@Test
	void testIntegerGreater13() {
		testValue = "Second 14 \"\" sentence.";
		testResult = SentenceValidator.validSentence(testValue);
		assertEquals(testResult, true);
	}
	
	//Given a fullstop is entered half way through the sentence then return false. 
	@Test
	void testFullStopEntered() {
		testValue = "Second 14. \"\" sentence.";
		testResult = SentenceValidator.validSentence(testValue);
		assertEquals(testResult, false);
	}
	
	//Given only one letter is entered return false
	@Test
	void testOneLeterIsEntered() {
		testValue = "a";
		testResult = SentenceValidator.validSentence(testValue);
		assertEquals(testResult, false);
	}

	// Given a word is entered with a capital and full stop. Then return false as it isn't a sentence
	@Test 
	void testOneWord() {
		testValue = "Abcd.";
		testResult = SentenceValidator.validSentence(testValue);
		assertEquals(testResult, false);
	}

}
