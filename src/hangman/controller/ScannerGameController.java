package hangman.controller;

import hangman.loader.ScannerWordLoader;
import hangman.loader.WordLoader;

import java.util.Scanner;

public class ScannerGameController extends GameController {
	private Scanner sc = new Scanner(System.in);

	public ScannerGameController() {
		loadWord();
	}

	private void printHangman() {
		Object[] args = null;
		switch (getNumErrors()) {
		case 0:
			args = new Object[] { "", "", "", "", "", "", "", "" };
			break;
		case 1:
			args = new Object[] { "O", "", "", "", "", "", "", "" };
			break;
		case 2:
			args = new Object[] { "O", "", "|", "", "", "", "", "" };
			break;
		case 3:
			args = new Object[] { "O", "/", "|", "", "", "", "", "" };
			break;
		case 4:
			args = new Object[] { "O", "/", "|", "\\", "", "", "", "" };
			break;
		case 5:
			args = new Object[] { "O", "/", "|", "\\", "/", "", "", "" };
			break;
		case 6:
			args = new Object[] { "O", "/", "|", "\\", "/", "\\","'","'" };
			break;
		}
		String stringTemplate = 	" _________     \n" 
								+ 	"|         |    \n" 
								+ 	"|         %s    \n" 
								+ 	"|        %s%s%s  \n" 
								+ 	"|        %s %s  \n"
								+ 	"|           %s  \n" 
								+ 	"|           %s  \n" 
								+ 	"\n";
		System.out.printf(stringTemplate, args);
	}

	private int getNumErrors() {
		return word.getWrongLettersSize();
	}

	private void printLetters() {
		System.out.println(word.printPlaceholders());
		System.out.println(word.printWrongLetters());
	}

	public void run() {
		
		
		while (canContinue()) {
//			System.out.println(word.getWord());
			printHangman();
			printLetters();

			System.out.print("\n\nPlease guess a letter!:");
			String guess = sc.next();
			char guessChar = validate(guess);
			word.checkGuess(guessChar);
		}
		printHangman();
		printLetters();
		System.out.println(word.printWinOrLose());
	}

	private boolean canContinue() {
		return word.canContinue();
	}

	private char validate(String guess) {
		char guessChar = validateGuessIsALetter(guess);
		guessChar = validateUnusedLetter(guessChar);
		return guessChar;
	}

	private char validateUnusedLetter(char guess) {
		while(word.isLetterUsed(guess)) {
			System.out.println("This letter has already been guessed. Please enter a new, unused letter: ");
			String temp = sc.next();
			validateGuessIsALetter(temp);
			guess = temp.charAt(0);
		}
		return guess;
	}
	
	private char validateGuessIsALetter(String guess) {
		while (guess.length() > 1) {
			System.out.println("Please only enter one character:");
			guess = sc.next();
		}
		return guess.charAt(0);
	}

	@Override
	public WordLoader getWordLoader() {
		return new ScannerWordLoader();
	}

}
