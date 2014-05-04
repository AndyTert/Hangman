package hangman.model;

import java.util.ArrayList;

public class HMWord {
	private final char UNDERSCORE = '_'; // 95

	private String word;
	private ArrayList<Character> placeholder;
	private ArrayList<Character> wrongLetters;
	private int length;

	public HMWord(String word) {
		this.setWord(word);
		length = word.length();
		setWrongLetters(new ArrayList<Character>());
		setPlaceholder(new ArrayList<Character>());

		for (int i = 0; i < length; i++) {
			getPlaceholder().add(UNDERSCORE);
		}
	}

	public void checkGuess(char guess) {
		if (word.contains(Character.toString(guess))) {
			for(int i = 0; i<length; i++) {
				char temp = word.charAt(i);
				if(temp == guess) {
					placeholder.set(i, guess);
				}				
			}
		} else {
			wrongLetters.add(guess);
		}
	}

	public String printPlaceholders() {
		StringBuilder result = new StringBuilder();
		result.append("Word: ");
		for (int i = 0; i < getPlaceholder().size(); i++) {
			char temp = getPlaceholder().get(i);
			result.append(temp);
			result.append(" ");
		}
		return result.toString();
	}

	public String printWrongLetters() {
		StringBuilder result = new StringBuilder();
		result.append("Wrong Letters: ");
		for (int i = 0; i < wrongLetters.size(); i++) {
			char temp = wrongLetters.get(i);
			result.append(temp);
		}
		return result.toString();
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public ArrayList<Character> getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(ArrayList<Character> placeholder) {
		this.placeholder = placeholder;
	}

	public void setWrongLetters(ArrayList<Character> wrongLetters) {
		this.wrongLetters = wrongLetters;
	}

	public int getWrongLettersSize() {
		return wrongLetters.size();
	}

	public boolean containsUnderscores() {
		boolean contains = false;
		if(placeholder.contains(UNDERSCORE)) {
			contains = true;
		}
		return contains;
	}

	public String printWinOrLose() {
		String result;
		if(!containsUnderscores()) {
			result = "YOU WIN!!";
		}else {
			result = "You're a loser...the word was: " + word;
		}
		return result;
	}
}
