package hangman.controller;

import hangman.loader.WordLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScannerGameController extends GameController {
	private Map<Character,Boolean> wordMap = new HashMap<Character, Boolean>();
	private ArrayList<String> guessedLetters = new ArrayList<String>();
	private ArrayList<String> wrongLetters = new ArrayList<String>();
	private Scanner sc = new Scanner(System.in);

	public ScannerGameController() {
		WordLoader w1 = new WordLoader();
		try {
			String word = w1.getWord();
			for (int i=0; i < word.length(); i++) {
				Character charAt = word.charAt(i);
				wordMap.put(charAt, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printHangman() {
		Object[] args = null;
		switch (getNumErrors()) {
		case 0:
			args = new Object[] { "", "", "", "", "", "" };
			break;
		case 1:
			args = new Object[] { "O", "", "", "", "", "" };
			break;
		case 2:
			args = new Object[] { "O", "", "|", "", "", "" };
			break;
		case 3:
			args = new Object[] { "O", "/", "|", "", "", "" };
			break;
		case 4:
			args = new Object[] { "O", "/", "|", "\\", "", "" };
			break;
		case 5:
			args = new Object[] { "O", "/", "|", "\\", "/", "" };
			break;
		case 6:
			args = new Object[] { "O", "/", "|", "\\", "/", "\\" };
			break;
		}
		System.out.printf(" _________     \n" + "|         |    \n" + "|         %s    \n" + "|        %s%s%s  \n" + "|        %s %s  \n"
				+ "|              \n" + "|              \n" + "\n", args);
	}

	private int getNumErrors() {
		return wrongLetters.size();
	}

	private void printLetters() {
		int wordLength = word.length();
		for (int i = 0; i < wordLength; i++) {
			System.out.print(" _ ");
		}

		System.out.println("  Wrong Guesses:" + wrongLetters.toString());
	}

	public void run() {
		while (canContinue()) {
			System.out.println(word);
			printHangman();
			printLetters();

			System.out.print("\n\nPlease guess a letter!:");
			String guess = sc.next();
			guess = validateGuess(guess);
			boolean contains = word.contains(guess);
			if (contains) {

			} else {
				System.out.println("Sorry...the word doesn't contain that letter.");
				wrongLetters.add(guess);
			}
		}
	}

	private boolean canContinue() {
		boolean canContinue = true;
//		if()
		return canContinue;
	}

	private String validateGuess(String guess) {
		while (guess.length() > 1) {
			System.out.println("Please only enter one character:");
			guess = sc.next();
		}
		return guess;
	}

}
