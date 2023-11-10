package stacksAndQueues;

import java.util.Stack;

public class LongestValidParentheses {

	private static int findMaxLen(String str) {
		int length = str.length();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int result = 0;
		for (int i = 0; i < length; i++) {
			if (str.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				}
				if (!stack.isEmpty()) {
					result = Math.max(result, i - stack.peek());
				}

				else {
					stack.push(i);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "((()()";

		System.out.println(findMaxLen(str));

		str = "()(()))))";

		System.out.println(findMaxLen(str));
	}

}

/*

Input : ((()
Output : 2
Explanation : ()
Input: )()())
Output : 4
Explanation: ()() 
Input:  ()(()))))
Output: 6
Explanation:  ()(())

*/