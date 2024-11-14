package string;

import java.util.Arrays;
import java.util.Stack;

public class Subsequence2 {
	public static void main(String[] args) {

		String s = "abc";
		String t = "ahbgdc";

		boolean result = isSubSeq(s, t);
		System.out.println(result);

	}

	private static boolean isSubSeq(String s, String t) {

		Stack<String> stk = new Stack<>();
		StringBuilder sb = new StringBuilder(s);
		s = sb.reverse().toString();

		for (Character ch : s.toCharArray()) {
			stk.push(ch.toString());
		}

		for (int i = 0; i < t.length(); i++) {
			if ((t.charAt(i) + "").equals(stk.peek())) {
				stk.pop();
			}
		}

		if (stk.isEmpty()) {
			return true;
		}

		return false;
	}

}

//Input: s = "abc", t = "ahbgdc"
