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
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		st.push(60);
		st.push(70);
		//printStack(st);
		System.out.println();
		SIZE = st.size();
		deleteMid(st, 0);
		printStack(st);
	}
}
