package bootcamp_mvn.stylometry;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Vocabulary {
	Map<String, Integer> wordFrequencies;
	public Vocabulary(String path) throws FileNotFoundException, IOException{
		this.wordFrequencies = FrequentWords.mostFrequentWords(FrequentWords.populateWordMap(path));
	}
}
