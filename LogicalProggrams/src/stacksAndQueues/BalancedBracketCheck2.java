package stacksAndQueues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBracketCheck2 {
	public static void main(String[] args) {

		String str = "[{((hh)}]";

		boolean flag = balancedBracket(str);
		if (flag) {
			System.out.println("The brackets are balanced");
		} else {
			System.out.println("No balanced brackets");
		}
	}

	private static boolean balancedBracket(String str) {

		Stack<Character> stk = new Stack<>();
		Map<Character, Character> hm = new HashMap<>();
		hm.put('(', ')');
		hm.put('[', ']');
		hm.put('{', '}');
		boolean isExtraChar = false;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (hm.containsKey(ch)) {
				stk.push(ch);
			}
			if (hm.containsValue(ch) && !stk.isEmpty()) {
				char a = stk.pop();
				if (hm.get(a) != ch) {
					return false;
				}
			} else {
				isExtraChar = true;
			}
		}
		return stk.isEmpty() && !isExtraChar;

	}
}
