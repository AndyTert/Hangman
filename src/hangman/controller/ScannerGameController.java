package hangman.controller;

import hangman.loader.WordLoader;

public class ScannerGameController extends GameController {
	private String word = "";
	private int numErrs = 0;

	public ScannerGameController() {
		WordLoader w1 = new WordLoader();
		try {
			word = w1.getWord();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void printHangman() {
		Object[] args = null;
		switch (numErrs) {
		case 0:
			args = new Object[] {"","","","","",""};
			break;
		case 1:
			args = new Object[] {"O","","","","",""};
			break;
		case 2:
			args = new Object[] {"O","","|","","",""};
			break;
		case 3:
			args = new Object[] {"O","/","|","","",""};
			break;
		case 4:
			args = new Object[] {"O","/","|","\\","",""};
			break;
		case 5:
			args = new Object[] {"O","/","|","\\","/",""};
			break;
		case 6:
			args = new Object[] {"O","/","|","\\","/","\\"};
			break;
		}
		System.out.printf(
				" _________     \n"
		    + 	"|         |    \n"
		    + 	"|         %s    \n"
		    + 	"|        %s%s%s  \n"
		    + 	"|        %s %s  \n"
		    + 	"|              \n"
		    + 	"|              \n"
		    + 	"\n"
			,args);
	}

	private void printLetters() {
		int wordLength = word.length();
		for (int i = 0; i < wordLength; i++) {
			System.out.print(" _ ");
		}
	}

	public void run() {
		//System.out.println(word);
		printHangman();
		printLetters();
		
//		System.out.print("\n\nPlease guess a letter!:");
	}


}
