package JUnitTests;

import main.SentenceValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class validSentenceTest {

	String testValue;
	boolean testResult;

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
		testValue = "Second two \" sentence";
		testResult = SentenceValidator.validSentence(testValue);
		assertEquals(testResult, false);
	}

	// Given that a negative number is entered quotations. But all other conditions are met
	// Then return false
	@Test
	void testNegativeNumberEntered() {
		testValue = "Second two \" sentence";
		testResult = SentenceValidator.validSentence(testValue);
		assertEquals(testResult, false);
	}
}
