package string;

import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		String s = "abcd";
		String t = "ahbgdc";

		boolean res = isSubSeq(s, t);
		System.out.println(res);

	}

	private static boolean isSubSeq(String s, String t) {

		int i = 0;
		int j = 0;

		while (i < s.length() && j < t.length()) {

			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			} else {
				j++;
			}

		}

		if (i == s.length()) {
			return true;
		}

		return false;

	}

}
