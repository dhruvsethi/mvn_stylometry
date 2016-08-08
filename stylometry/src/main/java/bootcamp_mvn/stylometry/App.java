package bootcamp_mvn.stylometry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	tokenizer tokenize = new tokenizer();
    	try {
    		tokenize.tokenizeRaw();
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	}
    		/*Author leoTolstoy;
    		System.out.println("Pass book path");
    		Scanner in = new Scanner(System.in);
    		String path = "c:\\Users\\dsethi\\Downloads\\of_human_bondage.txt";
    		path = in.nextLine();
    		try {
    			readBook(path);
    		} catch (FileNotFoundException e) {
    			System.out.println("File not found");
    		}
    	}

    	private static void readBook(String path) throws FileNotFoundException {
    		Scanner in = new Scanner(new File(path));
    		String book = "";
    		while (in.hasNextLine()) {
    			book += in.nextLine();
    		}
    		System.out.println(book);

    	}*/    
}
