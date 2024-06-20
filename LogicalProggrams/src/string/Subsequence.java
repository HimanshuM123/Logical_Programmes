package string;

import java.util.Arrays;



public class Subsequence {
	public static void main(String[] args) {

		String s = "abc";
		String t = "ahbgdc";

		int i = 0;
		int j = 0;
		char[] s_arr = s.toCharArray();
		char[] t_arr = t.toCharArray();

		while (i < s.length() && j < t.length()) {
			if (s_arr[i] == t_arr[j]) {
				i++;
			}
			j++;

		}
		System.out.println(i);
		if (i == s.length()) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

}

//Input: s = "abc", t = "ahbgdc"
