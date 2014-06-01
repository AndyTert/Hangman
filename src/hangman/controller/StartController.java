package hangman.controller;

import java.io.InputStream;

import hangman.loader.WordLoader;
import hangman.model.HMWord;

public class StartController extends GameController {

	private InputStream is;

	public StartController(InputStream is) {
		this.is = is;
		loadWord();
	}

	public HMWord getWord() {
		return word;
	}

	@Override
	public WordLoader getWordLoader() {
		WebWordLoader webWordLoader = new WebWordLoader();
		webWordLoader.setInputStream(is);
		return webWordLoader;
	}
}
