package bootcamp_mvn.stylometry;

import java.util.ArrayList;
import java.util.List;

import edu.emory.mathcs.nlp.component.tokenizer.token.Token;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Author leo = new Author();
		Double sentenceLength, paragraphLength;
		List<List<Token>> sentenceList = new ArrayList<List<Token>>();
		TokenizerDemo tokenize = new TokenizerDemo();
		try {
			sentenceList = tokenize.tokenizeRaw();
			sentenceLength = leo.findSentenceLength(sentenceList);
			System.out.println(sentenceLength);
			paragraphLength = leo.findParagraphLength(sentenceList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
