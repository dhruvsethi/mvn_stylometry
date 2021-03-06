package bootcamp_mvn.stylometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.emory.mathcs.nlp.component.tokenizer.token.Token;

public class Book {
	private List<String> wordFreq = new ArrayList<String>();
	private Map<String, Integer> punctFreq = new TreeMap<String, Integer>();
	private Integer paragraphLengthInSentences, paragraphLengthInWords, paragraphLengthInLetters, sentenceLengthInWords,
			sentenceLengthInLetters;

	private String bookName, bookPath;

	public Book(String name, String path) {
		this.bookName = name;
		this.bookPath = path;
	}

	public void debug() {
		System.out.println("Book [wordFreq=" + wordFreq + ", punctFreq=" + punctFreq + ", paragraphLengthInSentences="
				+ paragraphLengthInSentences + ", paragraphLengthInWords=" + paragraphLengthInWords
				+ ", paragraphLengthInLetters=" + paragraphLengthInLetters + ", sentenceLengthInWords="
				+ sentenceLengthInWords + ", sentenceLengthInLetters=" + sentenceLengthInLetters + "]");
	}

	@Override
	public String toString() {
		return "Book [wordFreq=" + wordFreq + ", punctFreq=" + punctFreq + ", paragraphLengthInSentences="
				+ paragraphLengthInSentences + ", paragraphLengthInWords=" + paragraphLengthInWords
				+ ", paragraphLengthInLetters=" + paragraphLengthInLetters + ", sentenceLengthInWords="
				+ sentenceLengthInWords + ", sentenceLengthInLetters=" + sentenceLengthInLetters + ", bookName="
				+ bookName + ", bookPath=" + bookPath + "]";
	}

	public List<String> getWordFreq() {
		return wordFreq;
	}

	public void setWordFreq(List<String> wordFreq) {
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

	public String getBookPath() {
		return bookPath;
	}

	public void setBookPath(String bookPath) {
		this.bookPath = bookPath;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

}
