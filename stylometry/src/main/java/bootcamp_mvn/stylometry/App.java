package bootcamp_mvn.stylometry;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		TokenizerDemo tokenize = new TokenizerDemo();
		try {
			tokenize.tokenizeRaw();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
