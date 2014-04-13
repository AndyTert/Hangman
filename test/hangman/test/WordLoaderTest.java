package hangman.test;

import java.util.ArrayList;

import hangman.loader.WordLoader;
import junit.framework.TestCase;

public class WordLoaderTest extends TestCase{

	public void testWordLoader() throws Exception {
		// setup
		WordLoader wl = new WordLoader();
		
		// execute
		ArrayList<String> words = wl.load();
		
		// assert
		assertEquals("The size should be 50", 50, words.size()); 
	}
	
	//TODO: WORD SELECTION
}
