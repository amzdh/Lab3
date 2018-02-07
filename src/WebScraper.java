import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    public static void main(String[] unused) {
        String word = "Prince";
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        text = text.toUpperCase();
        word = word.toUpperCase();
        int n = 0;
        String abc = text.replaceAll("[^[A-Z ]]","");
        String[] words = abc.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                n++;
            }
        }
        System.out.print(n);
        System.out.print("Alvis");
    }
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}

