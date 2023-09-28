package myPkg;

import java.util.Stack;

public class PolishNotation {

	public static void main(String[] args) {
	//	String[] tokens = { "2", "1", "+", "3", "*" };
		String[] tokens = { "4", "13", "5", "/", "+" };
		String operators = "+-*/";

		Stack<String> st = new Stack<String>();

		for (String obj : tokens) {
			if (!operators.contains(obj)) {
				st.push(obj);
			} else {

				int a = Integer.parseInt(st.pop());
				int b = Integer.parseInt(st.pop());
				if (obj == "+") {
					st.push(String.valueOf(a + b));
				}
				if (obj == "-") {
					st.push(String.valueOf(a + b));
				}
				if (obj == "*") {
					st.push(String.valueOf(a * b));
				}
				if (obj == "/") {
					st.push(String.valueOf(b / a));
				}

			}
		}
		
		System.out.println("The result is "+st.pop());
	}

}

//["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6