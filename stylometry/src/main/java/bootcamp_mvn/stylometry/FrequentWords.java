package bootcamp_mvn.stylometry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FrequentWords {
	private static final Integer ONE_BILLION = 1000000000;

	public static void main(String[] args) {
		try {
			System.out.println(
					mostFrequentWords(populateWordMap("C:\\Users\\dsethi\\Downloads\\of_human_bondage.txt")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Map<String, Integer> populateWordMap(String path) throws FileNotFoundException, IOException {
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		List<String> words = getWordsFromLines(readLines(path));
		for (String word : words) {
			if (wordMap.containsKey(word)) {
				wordMap.put(word, wordMap.get(word) + 1);
			} else {
				wordMap.put(word, 1);
			}
		}
		if (wordMap.containsKey("")) {
			System.out.println("wordmap Contains nothings");
		}
		return wordMap;
	}

	private static List<String> getWordsFromLines(List<String> lines) {
		List<String> words = new ArrayList<String>();
		for (String line : lines) {
			List<String> tokens = tokenize(line);
			for (String token : tokens) {
				if (!(getWordFromToken(token).equals(""))) {
					words.add(getWordFromToken(token));
				}
			}
		}
		return words;
	}

	private static String getWordFromToken(String token) {
		token = token.replace(",", "");
		token = token.replace(":", "");
		token = token.replace("-", "");
		token = token.replace("\\s+", "");
		token = token.replace("!", "");
		token = token.replace("?", "");
		token = token.replace("\n", "");
		token = token.replace("\n\\s*", "");
		token = token.replace(".", "");
		token = token.replace("'s", "");
		return token.toLowerCase();
	}

	private static List<String> tokenize(String line) {
		final String REGEX = "\\s+";
		List<String> tokens = Arrays.asList(line.split(REGEX));
		return tokens;
	}

	private static List<String> readLines(String path) throws FileNotFoundException, IOException {
		FileReader file = new FileReader(path);
		BufferedReader reader = new BufferedReader(file);
		List<String> lines = new ArrayList<String>();
		String singleLine = "";
		while ((singleLine = reader.readLine()) != null) {
			lines.add(singleLine);
		}
		return lines;
	}

	public static List<String> mostFrequentWords(int n, Map<String, Integer> wordMap) {
		Map<String,Integer> mostFrequentWords = sortFrequentWords(wordMap);
		List<String> result = new ArrayList<String>();
		for(String word : mostFrequentWords.keySet())
			result.add(word);
		return result;
	}
	
	public static Map<String,Integer> mostFrequentWords(Map<String, Integer> wordMap) {
		Map<String,Integer> mostFrequentWords = sortFrequentWords(wordMap);
		return mostFrequentWords;
	}

	private static Map<String,Integer> sortFrequentWords(Map<String, Integer> wordMap) {
		List<String> frequenciesWithWords = concatenateFrequenciesWithWords(wordMap);

		System.out.println(wordMap);
		Collections.sort(frequenciesWithWords, Collections.reverseOrder());
		Map<String,Integer> frequentWords = removeFrequencies(frequenciesWithWords);
		return frequentWords;
	}

	private static List<String> concatenateFrequenciesWithWords(Map<String, Integer> wordMap) {
		List<String> frequenciesWithWords = new ArrayList<String>();
		for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
			String frequencyWithWord = "";
			frequencyWithWord += Integer.toString(ONE_BILLION + entry.getValue());
			frequencyWithWord += entry.getKey();
			frequenciesWithWords.add(frequencyWithWord);
		}
		return frequenciesWithWords;
	}

	private static Map<String, Integer> removeFrequencies(List<String> frequenciesWithWords) {
		Map<String, Integer> wordsWithoutFrequencies = new TreeMap<String, Integer>();
		for (String word : frequenciesWithWords) {
			wordsWithoutFrequencies.put(word.substring(10), Integer.valueOf(word.substring(0, 10)) - ONE_BILLION);
		}
		return wordsWithoutFrequencies;
	}
}
