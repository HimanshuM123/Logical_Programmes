package myPkg;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstring {
	public static void main(String[] args) {
		String str = "javaconceptoftheday";

		Map<Character, Integer> hm = new LinkedHashMap<Character, Integer>();
		String longestStr = "";
		int longestLength = 0;

		for (int i = 0; i < str.length(); i++) {
			Character x = str.charAt(i);
			if (hm.get(x) == null) {
				hm.put(x, i);
			} else {
				i = hm.get(x);
				hm.clear();
			}

			if (hm.size() > longestLength) {
				longestLength = hm.size();
				longestStr = hm.keySet().toString();
			}
		}

		System.out.println("The longest substring withou repeating is " + longestStr);
	}
}
