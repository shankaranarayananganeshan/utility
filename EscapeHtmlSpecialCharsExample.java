import java.util.HashMap;

public class EscapeHtmlSpecialCharsExample {
	public static void main(String[] args) {

		String unEscapedString = "Hello <World> Goodbye & World";
		
		String escapedHTML = escapeHTMLSpecialChars(unEscapedString);
		System.out.println(escapedHTML);
	}


	public static String escapeHTMLSpecialChars(String s) {
		HashMap<Character, String> map = new HashMap<>();
		map.put('<', "&lt;");
		map.put('>', "&gt;");
		map.put('&', "&amp;");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '&':
				sb.append(map.get('&'));
				break;
			case '<':
				sb.append(map.get('<'));
				break;
			case '>':
				sb.append(map.get('>'));
				break;
			default:
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
