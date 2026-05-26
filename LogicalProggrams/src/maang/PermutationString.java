package maang;

import java.util.Arrays;

public class PermutationString {

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "eidbaooo";

		boolean result = checkInclusion(s1, s2);
		System.out.println(result);

	}

	public static boolean checkInclusion(String s1, String s2) {

		if (s1.length() > s2.length())
			return false;
		int[] count = new int[26];
		for (char c : s1.toCharArray()) {
			count[c - 'a']++;
		}
		int[] window = new int[26];
		for (int i = 0; i < s2.length(); i++) {
			window[s2.charAt(i) - 'a']++;
			if (i >= s1.length()) {
				window[s2.charAt(i - s1.length()) - 'a']--;
			}
			if (Arrays.equals(count, window))
				return true;
		}
		return false;

	}

}
