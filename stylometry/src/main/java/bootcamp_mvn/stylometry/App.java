package bootcamp_mvn.stylometry;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.emory.mathcs.nlp.component.tokenizer.token.Token;

public class App {
	public static void main(String[] args) throws Exception {
		Author sommerset = new Author();
		Book testBook = new Book(null, null);

		System.out.println("Compare to 1-The Magician, 2-War and Peace, 3-The Fountainhead");
		setTestBook(testBook);

		initTestBook(testBook);
		System.out.println(classify(sommerset, testBook));

	}

	private static void setTestBook(Book testBook) {
		Scanner in = new Scanner(System.in);

		switch (in.nextInt()) {
		case 1:
			testBook.setBookPath("c:\\Users\\dsethi\\Downloads\\the_magician.txt");
			break;
		case 2:
			testBook.setBookPath("c:\\Users\\dsethi\\Downloads\\WarAndPeace.txt");
			break;
		case 3:
			testBook.setBookPath("c:\\Users\\dsethi\\Downloads\\TheFountainhead.txt");
			break;
		}
		in.close();

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

	private static String classify(Author sommerset, Book testBook) throws FileNotFoundException, IOException {
		Integer sommersetParaLength = sommerset.getParagraphLengthInWords(),
				sommersetSentenceLength = sommerset.getSentenceLengthInWords(),
				testParaLength = testBook.getParagraphLengthInWords(),
				testSentenceLength = testBook.getSentenceLengthInWords(), score = 0;
		testBook.setWordFreq(
				FrequentWords.mostFrequentWords(15, FrequentWords.populateWordMap(testBook.getBookPath())));

		if (sommersetParaLength * 1.1 > testParaLength && testParaLength > 0.9 * sommersetParaLength)
			score++;

		if (sommersetSentenceLength * 1.1 > testSentenceLength && testSentenceLength > 0.9 * sommersetSentenceLength)
			score++;

		if (compareTopWords(sommerset.getWordFreq(), testBook.getWordFreq()) > 0.9)
			score++;

		if (score == 3)
			return "Sommerset";
		else
			return "Different author";
	}

	public static double compareTopWords(List<String> author, List<String> testBook) {
		int count = 0;
		for (String word : author) {
			if (testBook.contains(word))
				count++;
		}
		return (count * 100) / 15;
	}

}
