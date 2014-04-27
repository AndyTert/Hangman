package hangman.test;

import java.util.ArrayList;

import hangman.loader.WordLoader;
import junit.framework.TestCase;

public class WordLoaderTest extends TestCase {

	public void testWordLoader() throws Exception {
		// setup
		WordLoader wl = new WordLoader();

		// execute
		ArrayList<String> words = wl.load();

		// assert
		assertEquals("The size should be 50", 50, words.size());
	}

	public void testGetWord() throws Exception {
		// setup
		WordLoader w1 = new WordLoader();

		// execute
		String word = w1.getWord();

		// assert
		assertNotNull("The word should not be null", word);
		System.out.print(word);
	}
}
