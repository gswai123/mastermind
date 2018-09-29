package mastermind;

import java.util.Arrays;
import java.util.Scanner;

public class InputGuess {
	int guesses; 
	boolean testMode; 
	String code; 
	Scanner sc; 

	public InputGuess(int guesses, boolean testMode, String code, Scanner sc) {
		this.guesses = guesses; 
		this.testMode = testMode; 
		this.code = code;
		this.sc = sc; 
	}

	public void getGuess() {
		String[] history = new String[GameConfiguration.guessNumber]; 
		String guess;
		int i = guesses; 
		int j = 0; 
		if(testMode == true) {
			System.out.println("Secret Code: " + code);
			System.out.println("");
		} else {
			System.out.println(""); 
		}
		while(i > 0) {
			boolean hist = false; 
			System.out.println("You have " + i + " guess(es) left.");
			System.out.println("Enter guess:");
			guess = sc.next(); 

			if(guess.equals("HISTORY")){
				hist = true; 
			}

			CheckGuess checker = new CheckGuess(guess, code);
			boolean gameOver = checker.Winner();


			boolean valid = checker.ValidGuess(); 
			int[] pegs = checker.Pegs(); 

			if(hist == false && valid == true) {
				history[j] = guess + " -> " + Integer.toString(pegs[0]) + "b_" + Integer.toString(pegs[1]) + "w";
				j++; 
			}

			if(valid != false && hist == false) {
				System.out.println(guess + " -> " + pegs[0] + "b_" + pegs[1] +"w");
				if(gameOver != true) {
					System.out.println("");
				} 
				i--; 
			} 
			if(gameOver == true) {
				System.out.println("You win!");
				System.out.println("");
				return;
			}

			if(hist == true) {
				for (int n = 0; n < j; n++) {
					System.out.println(history[n]);
				}
				System.out.println("");
			}
		} 
		System.out.println("You lose! The pattern was " + code);
		System.out.println("");
	}
}


