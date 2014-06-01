package hangman.loader;

import java.io.IOException;
import java.util.ArrayList;

public abstract class WordLoader {

	public String getWord() throws IOException {
		int i = (int) Math.round((100 * Math.random()) / 2);
		ArrayList<String> words = load();
		String word = words.get(i);
		return word;
	}

	public abstract ArrayList<String> load() throws IOException;

}
