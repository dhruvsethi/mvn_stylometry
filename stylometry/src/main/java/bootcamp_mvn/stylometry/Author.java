package bootcamp_mvn.stylometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Author {
	String Name;
	List<Book> bookList;
	private List<String> wordFreq = new ArrayList<String>();
	private Map<String, Integer> punctFreq = new TreeMap<String, Integer>();
	private Integer paragraphLengthInSentences, paragraphLengthInWords, paragraphLengthInLetters, sentenceLengthInWords,
			sentenceLengthInLetters;

	public void setMetrics() {
		for (Book book : bookList) {
			this.setParagraphLengthInLetters(book.getParagraphLengthInLetters());
			this.setParagraphLengthInSentences(book.getParagraphLengthInSentences());
			this.setParagraphLengthInWords(book.getParagraphLengthInWords());
			this.setSentenceLengthInLetters(book.getSentenceLengthInLetters());
			this.setSentenceLengthInWords(book.getSentenceLengthInWords());
			this.setWordFreq(book.getWordFreq());
//			this.setPunctFreq();

		}
	}

	public List<String> getWordFreq() {
		return wordFreq;
	}

	public void setWordFreq(List<String> wordFreq) {
		this.wordFreq = wordFreq;
	}

	@Override
	public String toString() {
		return "Author [Name=" + Name + ", bookList=" + bookList + ", wordFreq=" + wordFreq + ", punctFreq=" + punctFreq
				+ ", paragraphLengthInSentences=" + paragraphLengthInSentences + ", paragraphLengthInWords="
				+ paragraphLengthInWords + ", paragraphLengthInLetters=" + paragraphLengthInLetters
				+ ", sentenceLengthInWords=" + sentenceLengthInWords + ", sentenceLengthInLetters="
				+ sentenceLengthInLetters + "]";
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Integer getParagraphLengthInSentences() {
		return paragraphLengthInSentences;
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

	public Integer getSentenceLengthInWords() {
		return sentenceLengthInWords;
	}

	public void setSentenceLengthInWords(Integer sentenceLengthInWords) {

		this.sentenceLengthInWords = sentenceLengthInWords;
	}

	public Integer getSentenceLengthInLetters() {
		return sentenceLengthInLetters;
	}

	public void setSentenceLengthInLetters(Integer sentenceLengthInLetters) {
	
		this.sentenceLengthInLetters = sentenceLengthInLetters;
	}

}
