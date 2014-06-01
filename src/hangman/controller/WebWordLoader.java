package hangman.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import hangman.loader.WordLoader;

public class WebWordLoader extends WordLoader {

	private InputStream is;

	public WebWordLoader() {
		super();
	}

	@Override
	public ArrayList<String> load() throws IOException {
		ArrayList<String> words = new ArrayList<String>();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader reader = new BufferedReader(isr);
		String line = reader.readLine();
		while (line != null) {
			words.add(line);
			line = reader.readLine();
		}
		return words;
	}

	public void setInputStream(InputStream is) {
		this.is = is;
	}

	
}
