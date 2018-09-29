package mastermind;

import java.util.Scanner;

public class Game {
		boolean testMode; 
		boolean status; 
		Scanner sc; 
		int guesses; 
		String[] History; 
		String code; 
		
	public Game(boolean testMode, boolean status, Scanner sc) {
		this.testMode = testMode;
		this.sc = sc; 
		this.status = status; 
		this.guesses = GameConfiguration.guessNumber; 
		
		
	}
	public void playGame() {
		while(status != false) {
			System.out.println("Do you want to play a new game? (Y/N):");
			if(sc.next().equals("N")) { 
				status = false;
				break; 
			} else {
				this.code = SecretCodeGenerator.getInstance().getNewSecretCode(); 
			}
			InputGuess input = new InputGuess(guesses, testMode, code, sc); 
			input.getGuess(); 
		}
	}
}




