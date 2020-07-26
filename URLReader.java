import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class URLReader {
	public static void main(String[] args) throws Exception {
		String searchWord = "india";
		URL url = new URL("https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page="+searchWord);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

		StringBuilder totalStr = new StringBuilder();
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			totalStr.append(inputLine);
		}
		String textStr = totalStr.toString().substring(totalStr.indexOf("\"text\":"));
		System.out.println("json str response is " + totalStr.toString());
		System.out.println("json str response for the text key value response is " + textStr);
		System.out.println("count of substring is " + getSubStringCountFromAString(textStr, searchWord));
		in.close();
	}

	private static int getSubStringCountFromAString(String textStr, String searchWord) {
		Pattern pattern = Pattern.compile(searchWord, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(textStr);

		int count = 0;
		int i = 0;
		while (matcher.find(i)) {
			count++;
			i = matcher.start() + 1;
		}

		System.out.println(count);
		return count;
	}

}
