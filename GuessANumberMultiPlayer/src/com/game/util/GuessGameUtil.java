package com.game.util;

/**
 * 
 * @author Sindhu VL
 *
 */
public class GuessGameUtil {

	/**
	 * Building the message to be shown using all these parameters. 
	 * @param secretNumber
	 * @param guess
	 * @param attempt
	 * @return
	 */
	public static String guessStatus(int secretNumber, int guess, int attempt) {
		if(secretNumber == guess) 
			return "Right! You have won the game.";
		
		if(attempt == 3 && (secretNumber-guess)!=0)
			return "Secret number is "+secretNumber+". Game Over! Please try again.";
			
		String guessStatus = difference(Math.abs(secretNumber-guess));
		return "Your"+ attempt(attempt) + "guess is "+ guess +" : " + guessStatus;
	
		
	}
	
	/**
	 * Using the absolute difference between secret number and the user guess, generating the status
	 * @param differnce
	 * @return
	 */
	public static String difference(int differnce) {
		switch (differnce) {
		case 1:
			return " (hot) ";
		case 2:
			return " (warm) ";
		default:
			return " (cold) ";
		}

	}
	
	/**
	 * With the use of attempt, generating the status 
	 * @param attempt
	 * @return
	 */
	public static String attempt(int attempt) {
		switch (attempt) {
		case 1:
			return " first ";
		case 2:
			return " second ";
		default:
			return " last ";
		}

	}
}
