package stacksAndQueues;

import java.util.Stack;

public class ReverseStack2 {

	private static void print(Stack<Integer> st) {
		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}

	private static Stack reverse(Stack<Integer> st) {
		Stack<Integer> stack = new Stack<>();
		while (!st.isEmpty()) {
			stack.push(st.pop());
		}

		return stack;
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		// print(st);
		Stack result = reverse(st);
		print(result);
	}

}
