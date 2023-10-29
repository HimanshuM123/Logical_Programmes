package string;

public class ValidPalindrome {
	public static void main(String[] args) {
		boolean result = validPalindrome("abcbah");
		System.out.println(result);
	}

	private static boolean validPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return (helperMethod(s, left + 1, right) || helperMethod(s, left, right - 1));
			}
			left++;
			right--;
		}
		return true;
	}

	private static boolean helperMethod(String s, int i, int j) {
		int left = i;
		int right = j;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}	
			left++;
			right--;
		}
		return true;
	}

}

/*
 * 
 * you may delete at-most one chatacter to judge whether to make string
 * palindrome
 * 
 * aba=> true; abca=> true; You can delete the character 'c'
 * 
 */