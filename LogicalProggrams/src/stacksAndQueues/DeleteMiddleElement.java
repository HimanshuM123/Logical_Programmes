package stacksAndQueues;

import java.util.Stack;

public class DeleteMiddleElement {

	private static int SIZE = 0;

	private static void deleteMid(Stack<Integer> st, int curr) {
		if (st.empty()) {
			return;
		}
		Integer x = st.pop();
		deleteMid(st, curr + 1);

		if (curr != SIZE / 2) {
			st.push(x);
		}
	}

	private static void printStack(Stack<Integer> st) {
		while (!st.empty()) {
			System.out.print(st.pop() + "  ");
		}
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		st.push(7);
		//printStack(st);
		System.out.println();
		SIZE = st.size();
		deleteMid(st, 0);
		printStack(st);
	}
}
