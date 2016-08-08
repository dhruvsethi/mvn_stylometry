package bootcamp_mvn.stylometry;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.emory.mathcs.nlp.component.tokenizer.token.Token;

public class Author {
	Map<String, Integer> wordFreq = new TreeMap<String, Integer>();
	Map<String, Integer> punctFreq = new TreeMap<String, Integer>();
	Integer paragraphLengthInSentences, paragraphLengthInWords, paragraphLengthInLetters, sentenceLengthInWords,
			sentenceLengthInLetters;

	public void debug() {
		System.out.println("Author [wordFreq=" + wordFreq + ", punctFreq=" + punctFreq + ", paragraphLengthInSentences="
				+ paragraphLengthInSentences + ", paragraphLengthInWords=" + paragraphLengthInWords
				+ ", paragraphLengthInLetters=" + paragraphLengthInLetters + ", sentenceLengthInWords="
				+ sentenceLengthInWords + ", sentenceLengthInLetters=" + sentenceLengthInLetters + "]");
	}

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

	public Double findSentenceLength(List<List<Token>> sentenceList) {
		Integer sentenceLength = 0, sentenceNumber = 0;
		for (List<Token> sentence : sentenceList) {
			sentenceLength += sentence.size();
			sentenceNumber++;
		}
		return Double.valueOf(sentenceLength / sentenceNumber);
	}

	public Double findParagraphLength(List<List<Token>> paragraphList) {
		Integer paragraphLength = 0, paragraphNumber = 0;
		for (List<Token> paragraph : paragraphList) {
			paragraphLength += paragraph.size();
			paragraphNumber++;
		}
		return Double.valueOf(paragraphLength / paragraphNumber);
	}

}
