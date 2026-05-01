package practice2;

import java.util.Stack;

public class RevStringStack {

	public static void main(String[] args) {
		String str = "ReverseMe";
		String result = "";

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			st.push(str.charAt(i));
		}

		while (!st.isEmpty()) {
			result = result + st.pop();
		}

		System.out.println("The reversed string is " + result);

	}

}
