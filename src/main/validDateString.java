package main;

public class validDateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "Are there 11, 12, or 13 lazy dogs?";
		System.out.println(validSentence(s));
	}
	
	public static boolean validSentence(String sentence) {
		int quoteCounter = 0; // variable to keep track of all quotation marks
		int digitCheck = 0; // variable to keep track of any digits in the sentence
		String[] mys = sentence.split(" ");
		
		switch(sentence.charAt(sentence.length()-1)) {
		case '.': break; 
		case '?' : break; 
		case '!' : break; 
		default: return false;
		}
		
		for(String x : mys) {
			if(x.contains(",") == true)
			try {
				 digitCheck = Integer.parseInt(x);
			}catch(Exception ex) {
				ex.toString(); 
			}
			
			if(digitCheck > 0 && digitCheck<=13) {
				return false;
			}
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
