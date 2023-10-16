package myPkg;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {

		Map<String, String> hm = new HashMap<>();
		hm.put("(", ")");
		hm.put("{", "}");
		hm.put("[", "]");

		String str = "(){}[]";
		Stack<Character> st = new Stack<>();
		for (Character o : str.toCharArray()) {
			String ch = o.toString();
			if (hm.keySet().contains(ch)) {
				st.push(o);
			} else if (hm.values().contains(ch)) {
				if (!st.isEmpty() && hm.get(st.peek().toString()).equals(ch)) {
					st.pop();
				}
			}
		}

		if (st.isEmpty()) {
			System.out.println("The parenthesis are valid");
		} else {
			System.out.println("The parenthesis are NOT valid");
		}

	}
}

/*
 * 
 * (){}[] -> valid
 * 
 * 
 * (){}[) -> Invalid
 * 
 */