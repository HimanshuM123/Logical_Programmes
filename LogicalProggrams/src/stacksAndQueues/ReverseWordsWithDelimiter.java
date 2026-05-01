package stacksAndQueues;

import java.util.Stack;

public class ReverseWordsWithDelimiter {
	public static void main(String[] args) {
		String country = "India-USA:#China#&Canada#Russia#Pakistan#Bangladesh";

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < country.length(); i++) {
			char ch = country.charAt(i);
			if (ch == '-' || ch == ':' || ch == '&' || ch == '#') {
				while (!st.isEmpty()) {

					System.out.print(st.pop().toString());
				}
				if (st.isEmpty()) {
					System.out.print(ch);
				}

			} else {

				st.push(ch);

			}
		}

		while (!st.isEmpty())

		{
			System.out.print(st.pop().toString());
		}
	}
}

/*
 * 
 * String country = "India-USA:#China#&Canada#Russia#Pakistan#Bangladesh";
 * 
 * Delimiters - : & #
 * 
 * String op = "aidnI-ASU:#anihC...."
 * 
 */