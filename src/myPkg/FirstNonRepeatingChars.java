package myPkg;


import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChars {
	public static void main(String[] args) {
		String str = "geeksforgeeks";

		Map<Character, Integer> hm = new LinkedHashMap<>();

		for (Character o : str.toCharArray()) {
			if (hm.get(o) == null) {
				hm.put(o, 1);
			} else {
				hm.put(o, hm.get(o) + 1);
			}
		}

		for (Map.Entry<Character, Integer> m : hm.entrySet()) {
			if (m.getValue() == 1) {
				System.out.println("The result is -->" + m.getKey());
				break;
			}
		}

	}
}

//geeksforgeeks -> f