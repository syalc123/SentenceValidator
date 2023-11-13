package main;

public class validDateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean validSentence(String sentence) {
		int quoteCounter = 0; // variable to keep track of all quotation marks
		
		String[] mys = sentence.split(" ");
		
		switch(sentence.charAt(sentence.length()-1)) {
		case '.': break; 
		case '?' : break; 
		case '!' : break; 
		default: return false;
		}
		
		for(String x : mys) {
			
		}
		
		
		
		/**
		 * Starting at 1 as we have already validated the first character as well as checking the last character
		 */
		for(int i = 1; i< sentence.length()-1; i++) {
			
			if(sentence.charAt(i)== '"') {
				quoteCounter++; 
			}
			
			if(sentence.charAt(i) == '.') {
				return false; 
			}
			
		}
		
		return quoteCounter %2 == 0 && Character.isUpperCase(sentence.charAt(0)); 
		
		

		
		
		
	}

}
