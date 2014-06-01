package hangman.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class ScannerWordLoader extends WordLoader {
	private static final String FILE_LOCATION = "/res/words.txt";

	public ArrayList<String> load() throws IOException {

		ArrayList<String> words = new ArrayList<String>();
		File file = new File(FILE_LOCATION);
		Reader r = null;
		BufferedReader br = null;
		try {
			r = new FileReader(file);
			br = new BufferedReader(r);

			String line = br.readLine();
			while (line != null) {
				words.add(line);
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
				r.close();
			}
		}
		return words;
	}

}
