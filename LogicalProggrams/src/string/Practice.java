package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class Practice {
	public static void main(String[] args) {
		String str ="loveleetcode";
		String result = firstUniqChar(str);
		System.out.println(result);
		
	}

	private static String firstUniqChar(String str) {

		String result = "";

		Map<Character, Integer> hm = new LinkedHashMap<>();

		for (int i = 0; i < str.length(); i++) {

			Character ch = str.charAt(i);
			if (hm.get(ch) == null) {
				hm.put(ch, 1);
			} else {
				hm.put(ch, hm.get(ch) + 1);
			}

		}

		for (Map.Entry<Character, Integer> obj : hm.entrySet()) {

			if (obj.getValue() == 1) {
				result = obj.getKey().toString();
				break;
			}
		}

		System.out.println(hm);

		return result;

	}


}
