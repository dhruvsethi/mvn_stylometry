package bootcamp_mvn.stylometry;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Author {
	String Name;
	List<Book> bookList;
	private Map<String, Integer> wordFreq = new TreeMap<String, Integer>();
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
//			this.setWordFreq();
//			this.setPunctFreq();

		}
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
		paragraphLengthInSentences = (this.getParagraphLengthInSentences() * this.bookList.size() + paragraphLengthInSentences)
				/ (this.getBookList().size() + 1);
		this.paragraphLengthInSentences = paragraphLengthInSentences;
	}

	public Integer getParagraphLengthInWords() {
		return paragraphLengthInWords;
	}

	public void setParagraphLengthInWords(Integer paragraphLengthInWords) {
		paragraphLengthInWords = (this.getParagraphLengthInWords() * this.bookList.size() + paragraphLengthInWords)
				/ (this.getBookList().size() + 1);
		this.paragraphLengthInWords = paragraphLengthInWords;
	}

	public Integer getParagraphLengthInLetters() {
		return paragraphLengthInLetters;
	}

	public void setParagraphLengthInLetters(Integer paragraphLengthInLetters) {
		paragraphLengthInLetters = (this.getParagraphLengthInLetters() * this.bookList.size() + paragraphLengthInLetters)
				/ (this.getBookList().size() + 1);
		this.paragraphLengthInLetters = paragraphLengthInLetters;
	}

	public Integer getSentenceLengthInWords() {
		return sentenceLengthInWords;
	}

	public void setSentenceLengthInWords(Integer sentenceLengthInWords) {
		sentenceLengthInWords = (this.getSentenceLengthInWords() * this.bookList.size() + sentenceLengthInWords)
				/ (this.getBookList().size() + 1);
		this.sentenceLengthInWords = sentenceLengthInWords;
	}

	public Integer getSentenceLengthInLetters() {
		return sentenceLengthInLetters;
	}

	public void setSentenceLengthInLetters(Integer sentenceLengthInLetters) {
		sentenceLengthInLetters = (this.getSentenceLengthInLetters() * this.bookList.size() + sentenceLengthInLetters)
				/ (this.getBookList().size() + 1);
		this.sentenceLengthInLetters = sentenceLengthInLetters;
	}

}
