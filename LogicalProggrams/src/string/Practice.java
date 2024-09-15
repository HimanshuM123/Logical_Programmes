package string;

import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
		boolean result = validPalindrome("abcdefedcbah");
		System.out.println(result);
	}

	private static boolean validPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				boolean x = helper(str, left + 1, right);
				boolean y = helper(str, left, right - 1);
				return x || y;

			}

			left++;
			right--;
		}
		return false;

	}

	private static boolean helper(String str, int left, int right) {

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;

			}

			left++;
			right--;
		}
		return true;
	}

}
