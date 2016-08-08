package bootcamp_mvn.stylometry;

import java.util.Map;
import java.util.TreeMap;

public class Author {
	Map<String, Integer> wordFreq = new TreeMap<String, Integer>();
	Map<String, Integer> punctFreq = new TreeMap<String, Integer>();
	Integer paragraphLengthInSentences, paragraphLengthInWords, paragraphLengthInLetters, sentenceLengthInWords,
			sentenceLengthInLetters;

	public Map<String, Integer> getWordFreq() {
		return wordFreq;
	}

	public void setWordFreq(Map<String, Integer> wordFreq) {
		this.wordFreq = wordFreq;
	}

	public Map<String, Integer> getPunctFreq() {
		return punctFreq;
	}

	public void setPunctFreq(Map<String, Integer> punctFreq) {
		this.punctFreq = punctFreq;
	}

	public Integer getParagraphLengthInSentences() {
		return paragraphLengthInSentences;
	}

	public Integer getSentenceLengthInWords() {
		return sentenceLengthInWords;
	}

	public void setSentenceLengthInWords(Integer sentenceLengthInWords) {
		this.sentenceLengthInWords = sentenceLengthInWords;
	}

	public void setParagraphLengthInSentences(Integer paragraphLengthInSentences) {
		this.paragraphLengthInSentences = paragraphLengthInSentences;
	}

	public Integer getParagraphLengthInWords() {
		return paragraphLengthInWords;
	}

	public void setParagraphLengthInWords(Integer paragraphLengthInWords) {
		this.paragraphLengthInWords = paragraphLengthInWords;
	}

	public Integer getParagraphLengthInLetters() {
		return paragraphLengthInLetters;
	}

	public void setParagraphLengthInLetters(Integer paragraphLengthInLetters) {
		this.paragraphLengthInLetters = paragraphLengthInLetters;
	}

	public Integer getSentenceLengthInLetters() {
		return sentenceLengthInLetters;
	}

	public void setSentenceLengthInLetters(Integer sentenceLengthInLetters) {
		this.sentenceLengthInLetters = sentenceLengthInLetters;
	}
	

}
