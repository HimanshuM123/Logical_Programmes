package practice2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBracketCheckTest {
	public static void main(String[] args) {
		String expr = "([{}])";
		if (isBalancedBracket(expr)) {
			System.out.println("Brackets are balanced");
		} else {
			System.out.println("Brackets are NOT balanced");
		}
	}

	private static boolean isBalancedBracket(String expr) {

		Map<String, String> hm = new HashMap<>();
		hm.put("(", ")");
		hm.put("[", "]");
		hm.put("{", "}");
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < expr.length(); i++) {
			char ch = expr.charAt(i);
			if (hm.containsKey(String.valueOf(ch))) {
				stack.add(String.valueOf(ch));
			} else {
				String s = stack.pop();
				String val = hm.get(s);
				if (!val.equalsIgnoreCase(String.valueOf(ch))) {
					return false;
				}
			}

		}
		return true;

	}

}
