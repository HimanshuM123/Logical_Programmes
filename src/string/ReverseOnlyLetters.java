package string;

import java.util.Stack;

public class ReverseOnlyLetters {

	public static void main(String[] args) {
		String str = "ab-C-dEf-ghIj";
		Stack<Character> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (Character ch : str.toCharArray()) {
			if (Character.isLetter(ch)) {
				stk.push(ch);
			}
		}

		for (Character ch : str.toCharArray()) {
			if (Character.isLetter(ch)) {
				sb.append(stk.pop());
			} else {
				sb.append(ch);
			}
		}
		System.out.println(sb.toString());
	}

}


/*

ab-C-dEf-ghIj

jI-h-gfE-dCba

*/