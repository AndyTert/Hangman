package hangman.controller;

import hangman.loader.WordLoader;
import hangman.model.HMWord;

import java.util.Scanner;

public class ScannerGameController extends GameController {
	private HMWord word;

	private Scanner sc = new Scanner(System.in);

	public ScannerGameController() {
		WordLoader w1 = new WordLoader();
		try {
			String wordString = w1.getWord();
			word = new HMWord(wordString);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			System.out.println(word.getWord());
			printHangman();
			printLetters();

			System.out.print("\n\nPlease guess a letter!:");
			String guess = sc.next();
			char guessChar = validateGuess(guess);
			word.checkGuess(guessChar);
		}
		printHangman();
		printLetters();
		System.out.println(word.printWinOrLose());
	}

	private boolean canContinue() {
		boolean cont = false;
		if (word.containsUnderscores()) {
			cont = true;
		} 
		if (word.getWrongLettersSize() == 6) {
			cont = false;
		}

		return cont;
	}

	private char validateGuess(String guess) {
		while (guess.length() > 1) {
			System.out.println("Please only enter one character:");
			guess = sc.next();
		}
		return guess.charAt(0);
	}

}
