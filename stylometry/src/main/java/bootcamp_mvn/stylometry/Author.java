package bootcamp_mvn.stylometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import edu.emory.mathcs.nlp.component.tokenizer.token.Token;

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
			// this.setPunctFreq();

		}
	}

	public Author() {
		Double sentenceLengthInWords = 0.0, paragraphLengthInWords = 0.0;
		List<List<Token>> paragraphList = new ArrayList<List<Token>>();
		List<List<Token>> sentenceList = new ArrayList<List<Token>>();
		this.setBookList(initBookList());
		TokenizerDemo tokenize = new TokenizerDemo();
		try {
			for (Book book : this.getBookList()) {
				paragraphList = tokenize.tokenizeLine(book.getBookPath());
				sentenceList = tokenize.tokenizeRaw(book.getBookPath());
				paragraphLengthInWords += book.findParagraphLength(paragraphList);
				sentenceLengthInWords += book.findSentenceLength(sentenceList);
				book.setWordFreq(
						FrequentWords.mostFrequentWords(15, FrequentWords.populateWordMap(book.getBookPath())));
			}
			this.setSentenceLengthInWords(sentenceLengthInWords.intValue() / this.getBookList().size());
			this.setParagraphLengthInWords(paragraphLengthInWords.intValue() / this.getBookList().size());
			this.setWordFreq(aggregateTopWords(this.getBookList()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<String> aggregateTopWords(List<Book> bookList) {

		List<String> aggregateList = new ArrayList<String>();

		for (Book book : bookList) {
			for (String word : book.getWordFreq()) {
				if (!(aggregateList.contains(word)))
					aggregateList.add(word);
			}
		}

		return aggregateList;

	}

	private static List<Book> initBookList() {
		List<Book> bookList = new ArrayList<Book>();

		bookList.add(new Book("Of Human Bondage", "c:\\Users\\dsethi\\Downloads\\of_human_bondage.txt"));
		bookList.add(new Book("Of Moon And Sixpence", "c:\\Users\\dsethi\\Downloads\\the_moon_and_sixpence.txt"));
		bookList.add(new Book("The Magician", "c:\\Users\\dsethi\\Downloads\\the_magician.txt"));

		return bookList;
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
