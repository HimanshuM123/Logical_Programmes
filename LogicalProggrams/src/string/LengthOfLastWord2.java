package string;

import java.util.Stack;

public class LengthOfLastWord2 {

	public static void main(String[] args) {
		String str = "Hello World   ";

		Stack<String> stk = new Stack<>();

		String[] arr = str.split(" ");
		int counter = arr.length;
		int i = 0;

		while (counter > 0) {
			stk.push(arr[i]);
			counter--;
			i++;

		}

		System.out.println(stk.pop().length());

	}

}
