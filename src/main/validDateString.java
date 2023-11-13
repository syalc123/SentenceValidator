package main;

public class validDateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean validSentence(String sentence) {
		int quoteCounter = 0;
		if(!Character.isUpperCase(sentence.charAt(0))) {
			return false;
		}
		
		switch(sentence.charAt(sentence.length()-1)) {
		case '.': break; 
		case '?' : break; 
		case '!' : break; 
		default: return false;
		}
		
		
		/**
		 * Starting at 1 as we have already validated the first character as well as checking the last character
		 */
		for(int i = 1; i< sentence.length()-1; i++) {
			
			if(sentence.charAt(i)== '"') {
				quoteCounter++; 
				
			}
		}
		

		
		return true; 
		
	}

}
