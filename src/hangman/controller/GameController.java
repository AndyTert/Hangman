package hangman.controller;

import hangman.loader.WordLoader;
import hangman.model.HMWord;

public abstract class GameController {

	protected HMWord word;

	public void loadWord() {
		WordLoader w1 = getWordLoader();
		try {
			String wordString = w1.getWord();
			word = new HMWord(wordString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract WordLoader getWordLoader();

}
