package bootcamp_mvn.stylometry;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		tokenizer tokenize = new tokenizer();
		try {
			tokenize.tokenizeRaw();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
