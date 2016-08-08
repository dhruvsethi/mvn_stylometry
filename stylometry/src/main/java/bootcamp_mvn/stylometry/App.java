package bootcamp_mvn.stylometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.emory.mathcs.nlp.component.tokenizer.token.Token;

public class App {
	public static void main(String[] args) throws Exception {
		Author sommerset = new Author();
		Book testBook = new Book();
		Scanner in = new Scanner(System.in);

		sommerset = initSommerset();
		System.out.println("Enter book path");
		testBook.setBookPath(in.next());
		in.close();

		initTestBook(testBook);
		System.out.println(classify(sommerset, testBook));

	}

	private static void initTestBook(Book testBook) throws Exception {
		TokenizerDemo tokenize = new TokenizerDemo();
		List<List<Token>> paragraphList = new ArrayList<List<Token>>();
		List<List<Token>> sentenceList = new ArrayList<List<Token>>();

		paragraphList = tokenize.tokenizeLine(testBook.getBookPath());
		sentenceList = tokenize.tokenizeRaw(testBook.getBookPath());
		testBook.setParagraphLengthInWords(testBook.findParagraphLength(paragraphList).intValue());
		testBook.setSentenceLengthInWords(testBook.findSentenceLength(sentenceList).intValue());

	}

	private static String classify(Author sommerset, Book testBook) {
		Integer sommersetParaLength = sommerset.getParagraphLengthInWords(),
				sommersetSentenceLength = sommerset.getSentenceLengthInWords(),
				testParaLength = testBook.getParagraphLengthInWords(),
				testSentenceLength = testBook.getSentenceLengthInWords(), score = 0;

		if (sommersetParaLength * 1.1 > testParaLength && testParaLength > 0.9 * sommersetParaLength)
			score++;

		if (sommersetSentenceLength * 1.1 > testSentenceLength && testSentenceLength > 0.9 * sommersetSentenceLength)
			score++;

		if (score > 1)
			return "Same author";
		else
			return "Different author";
	}

	private static Author initSommerset() {
		Author sommerset = new Author();
		Double sentenceLengthInWords = 0.0, paragraphLengthInWords = 0.0;
		List<List<Token>> paragraphList = new ArrayList<List<Token>>();
		List<List<Token>> sentenceList = new ArrayList<List<Token>>();
		FrequentWords wordFreq = new FrequentWords();
		sommerset.setBookList(initBookList());
		TokenizerDemo tokenize = new TokenizerDemo();
		try {
			for (Book book : sommerset.getBookList()) {
				paragraphList = tokenize.tokenizeLine(book.getBookPath());
				sentenceList = tokenize.tokenizeRaw(book.getBookPath());
				paragraphLengthInWords += book.findParagraphLength(paragraphList);
				sentenceLengthInWords += book.findSentenceLength(sentenceList);
				book.setWordFreq(FrequentWords.mostFrequentWords(15, FrequentWords.populateWordMap(book.getBookPath())));
			}
			sommerset.setSentenceLengthInWords(sentenceLengthInWords.intValue() / sommerset.getBookList().size());
			sommerset.setParagraphLengthInWords(paragraphLengthInWords.intValue() / sommerset.getBookList().size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sommerset;

	}

	private static List<Book> initBookList() {
		List<Book> bookList = new ArrayList<Book>();
		Book book1 = new Book();
		book1.setBookName("Of Human Bondage");
		book1.setBookPath("c:\\Users\\dsethi\\Downloads\\of_human_bondage.txt");

		Book book2 = new Book();
		book2.setBookName("Of Moon And Sixpence");
		book2.setBookPath("c:\\Users\\dsethi\\Downloads\\the_moon_and_sixpence.txt");

		Book book3 = new Book();
		book3.setBookName("The Magician");
		book3.setBookPath("c:\\Users\\dsethi\\Downloads\\the_magician.txt");

		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);

		return bookList;
	}

}
