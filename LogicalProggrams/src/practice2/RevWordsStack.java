package practice2;

import java.util.Stack;

public class RevWordsStack {
	public static void main(String[] args) {
		String str = "Java is secure";
		String result = "";
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) != ' ') {
				st.push(str.charAt(i));
			} else {
				while (!st.isEmpty()) {
					result = result + st.pop();
				}
				result = result + " ";
			}
		}

		while (!st.isEmpty()) {
			result = result + st.pop();
		}

		System.out.println(result);
	}
}
