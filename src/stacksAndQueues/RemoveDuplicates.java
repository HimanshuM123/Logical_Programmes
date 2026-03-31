package stacksAndQueues;

import java.util.Stack;

public class RemoveDuplicates {
	public static void main(String[] args) {
		String str = "deeedbbcccbdaa";
		String result = removeDuplicates(str,3);
		System.out.println(result);
		
	}

	public static String removeDuplicates(String s, int k) {
		Stack<Pair> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek().character == c) {
				stack.peek().count++;
			} else {
				stack.push(new Pair(c, 1));
			}
			if (stack.peek().count == k) {
				stack.pop();
			}
		}
		StringBuilder res = new StringBuilder();
		for (Pair pair : stack) {
			for (int i = 0; i < pair.count; i++) {
				res.append(pair.character);
			}
		}
		return res.toString();
	}

	private static class Pair {
		char character;
		int count;

		Pair(char character, int count) {
			this.character = character;
			this.count = count;
		}
	}

}


/*


s ="deeedbbcccbdaa" k=3 remove 3 consecutive chars
    ddbbcccbdaa
    ddbbbdaa
    dddaa
    aa


output = aa






*/