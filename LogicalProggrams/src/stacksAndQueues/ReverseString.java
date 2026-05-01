package stacksAndQueues;

import java.util.Stack;

public class ReverseString {
	public static void main(String[] args) {
		String str = "ReverseMe";
		String reversedString = "";

		Stack<Character> st = new Stack<>();

		for (Character ch : str.toCharArray()) {
			st.push(ch);
		}
		
		while(!st.isEmpty()) {
			Character ch1 = st.pop();
			reversedString = reversedString +ch1;
		}
		
		System.out.println("The reversed string is ->"+reversedString);

	}
}
