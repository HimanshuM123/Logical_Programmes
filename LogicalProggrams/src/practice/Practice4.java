package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice4 {

	public static void main(String[] args) {
		String str1 = "braggg";
		String str2 = "gggrab";
		if (isAnagram(str1, str2)) {
			System.out.println("The strings are anagrams");
		} else {
			System.out.println("The strings are NOT anagrams");
		}

	}

	private static boolean isAnagram(String str1, String str2) {

		Map<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < str1.length(); i++) {

			char ch = str1.charAt(i);

			if (hm.get(ch) == null) {
				hm.put(ch, 1);
			} else {
				hm.put(ch, hm.get(ch) + 1);
			}

		}

		for (int i = 0; i < str2.length(); i++) {

			char ch = str2.charAt(i);

			if (hm.get(ch) != null && hm.get(ch) > 1) {
				hm.put(ch, hm.get(ch) - 1);
			}

		}

		for (Map.Entry<Character, Integer> obj : hm.entrySet()) {
			if (obj.getValue() > 1) {
				return false;
			}
		}

		return true;

	}

}
