package stacksAndQueues;

import java.util.Stack;

public class BalancedBracketCheck {
	public static void main(String[] args) {

		String expr = "([{(}])";
		if (isBalancedBracket(expr)) {
			System.out.println("Brackets are balanced");
		} else {
			System.out.println("Brackets are NOT balanced");
		}
	}

	private static boolean isBalancedBracket(String str) {

		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {

			Character ch = str.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			
			}
			if (ch == ')') {
				char close = st.pop();
				if (close == '}' || close == ']') {
					return false;
				}
			}
			if (ch == '}') {
				char close = st.pop();
				if (close == ')' || close == ']') {
					return false;
				}
			}
			if (ch == ']') {
				char close = st.pop();
				if (close == '}' || close == ')') {
					return false;
				}
			}

		}

		return st.isEmpty();

	}
}
