package practice2;

import java.util.Stack;

public class MyPractice {
	public static void main(String[] args) {

		String str = "Geeks for Geeks1";
		String rev = "";

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch != ' ') {
				st.push(ch);
			} else {
				while (!st.isEmpty()) {
					rev = rev + st.pop();
				}
				rev = rev +" ";
			}
		}
		while (!st.isEmpty()) {
			rev = rev + st.pop();
		}
		
		System.out.println(rev);

	}
}
