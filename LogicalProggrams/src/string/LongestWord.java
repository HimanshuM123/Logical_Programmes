package string;

import java.util.Arrays;

public class LongestWord {
	public static void main(String[] args) {
		String str = "Find the longest world";

		int longestLength = 0;
		String longestWord = "";

		String arr[] = str.split(" ");
		int i = 0;
		while (i < arr.length) {
			if (longestLength < arr[i].length()) {
				longestLength = arr[i].length();
				longestWord = arr[i];
			}
			i++;
		}

		System.out.println(longestWord);

	}

}
