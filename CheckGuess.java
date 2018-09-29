package mastermind;

public class CheckGuess {
	String guess; 
	String code; 

	public CheckGuess(String guess, String code) {
		this.guess = guess; 
		this.code = code; 
	}

	public boolean Winner() {
		boolean winner = false; 
		if(guess.equals(code)) {
			winner = true; 
		}
		return winner; 
	}

	public boolean ValidGuess() {
		boolean valid = true; 
		if(guess.length() != GameConfiguration.pegNumber) {
			valid = false; 
		}

		if(!guess.equals(guess.toUpperCase())) {
			valid = false; 
		}

		String[] guessArray = guess.split(""); 
		String [] colors = GameConfiguration.colors; 
		for(int i = 0; i < guessArray.length; i++) {
			boolean inColorArray = false; 
			for(int j = 0; j < colors.length; j++) {
				if(guessArray[i].equals(colors[j])) {
					inColorArray = true; 
				}
			}
			if(inColorArray == false) {
				valid = false; 
			}
		}
		if(guess.equals("HISTORY")) {
			valid = true; 
		}
		if(valid == false) {
			System.out.println("INVALID_GUESS"); 
			System.out.println("");
		}
		return valid; 
	}

	public int[] Pegs() { // Pegs that are correct and in right place
		int[] pegs = new int[2];
		int w_pegs = 0; 
		int b_pegs = 0; 
		int count = GameConfiguration.pegNumber; 
		char[] guessArray = guess.toCharArray(); 
		char[] codeArray = code.toCharArray(); 
		for(int i = 0; i < count; i++) {
			if(guessArray[i] == codeArray[i]) {
				guessArray[i] = '0';
				codeArray[i] = '1'; 
				b_pegs++;
			}
		}
		for(int i = 0; i < count; i++) {
			for(int j = 0; j < count; j++) {
				if(guessArray[i] == codeArray[j]) {
					guessArray[i] = '0';
					codeArray[j] = '1'; 
					w_pegs++; 
				}	
			}
		}
		pegs[0] = b_pegs; 
		pegs[1] = w_pegs; 
		return pegs; 
	}
}
