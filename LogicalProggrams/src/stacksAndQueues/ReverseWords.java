package stacksAndQueues;

import java.util.Stack;

public class ReverseWords {
	public static void main(String[] args) {
		String str = "Geeks for Geeks1";

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				st.push(str.charAt(i));
			} else {
				while (!st.empty()) {
					System.out.print(st.pop());
				}
				System.out.print(" ");
			}
		}

		while (!st.empty()) {
			System.out.print(st.pop());
		}

	}
}
