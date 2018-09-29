package mastermind;
import java.util.Scanner;


public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean status = true; 
		boolean testMode; 
		if((args.length) == 0) {
			testMode = false;  
		} else {
			String input = args[0]; 
			if(input.equals("1")) {
				testMode = true; 
			} else {
				testMode = false; 
			}
		}
		System.out.println("Welcome to Mastermind.");
		Game myGame = new Game(testMode, status, sc);
		myGame.playGame(); 
		
	}
}


