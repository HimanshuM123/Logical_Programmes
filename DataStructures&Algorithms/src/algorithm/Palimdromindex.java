package algorithm;

//remove one character from string to make string palimdrome
// aabccccaa  --> 2

public class Palimdromindex {
	
	static int palimdromeIndex(String str) {
		int palimdromeIndex = -1;
		int len = str.length();

		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				if (i + 1 < len) {
					boolean isRightStringPalimdrome = isValidPalimdrome(str.substring(i + 1, len - i));
					if (isRightStringPalimdrome) {
						return i;
					} else {
						return len - i - 1;
					}
				}
			}
		}
		return palimdromeIndex;

	}

	public static boolean isValidPalimdrome(String str) {//madam
		boolean isPalimdrome = true;
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
				isPalimdrome = false;
				break;
			}
		}
		return isPalimdrome;
	}

	public static void main(String[] args) {
		System.out.println(palimdromeIndex("aabccccaa"));

	}

}
