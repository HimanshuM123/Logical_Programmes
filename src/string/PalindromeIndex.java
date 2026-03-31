package string;

public class PalindromeIndex {
	public static void main(String[] args) {

		int result = palindromeIndex("bcbc");
		System.out.println(result);
	}
	
	static int palindromeIndex(String s) {
		int palindromeIndex = -1;
		int len = s.length();

		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {
				if (i + 1 < len) {
					boolean isRightStringValidPalindrome = isValidPalindrome(s.substring(i + 1, len - i));
					if (isRightStringValidPalindrome)
						return i;
					return len - i - 1;
				}
			}
		}

		return palindromeIndex;

	}
	
	public static boolean isValidPalindrome(String str) {
		int len = str.length();

		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				return false;
			}
		}

		return true;

	}
}


/*

Given a string of lowercase letters in the range ascii[a-z], determine the index of a character that can be removed to make the string a palindrome. There may be more than one solution, but any will do. If the word is already a palindrome or there is no solution, return -1. Otherwise, return the index of a character to remove.

Example
bcbc 

Either remove 'b' at index  or 'c' at index .




*/