package codingInterview;

public class SubSequence {

	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";

		boolean result = isSubSequence(s, t);
		System.out.println(result);
	}

	private static boolean isSubSequence(String s, String t) {

		int i = 0;
		int j = 0;

		while (j < t.length()) {

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
