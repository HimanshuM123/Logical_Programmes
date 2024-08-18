package stacksAndQueues;

import java.util.Stack;

public class RemoveKDigits {
	public static void main(String[] args) {
		String num = "1432219";
		int k = 3;
		String result = removeKdigits(num, k);
		System.out.println(result);// 1219

	}

	public static String removeKdigits(String num, int k) {
		Stack<Character> stack = new Stack<>();

		for (char c : num.toCharArray()) {
			while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
				stack.pop();
				k--;
			}
			stack.push(c);
		}

		// Handle the case where k digits remain to be removed
		while (k > 0) {
			stack.pop();
			k--;
		}

		// Build the resulting string
		StringBuilder res = new StringBuilder();
		for (char c : stack) {
			res.append(c);
		}

		// Remove leading zeros
		while (res.length() > 0 && res.charAt(0) == '0') {
			res.deleteCharAt(0);
		}

		// Return the result or "0" if the string is empty
		return res.length() == 0 ? "0" : res.toString();
	}
}
