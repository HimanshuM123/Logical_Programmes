package stacksAndQueues;

import java.util.Stack;

public class ReverseStack {

    static Stack<Integer> stack = new Stack<>();

	private static void print(Stack<Integer> st) {
		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}

	private static void inserAtBottom(Integer x) {
		if(stack.isEmpty()) {
			stack.push(x);
		}else {
			Integer ele = stack.pop();
			inserAtBottom(x);
			stack.push(ele);
		}
		
	}
	
	
	private static void reverse(Stack<Integer> st) {
		if (st.isEmpty()) {
			return;
		}
		Integer ele = st.pop();
		reverse(st);
		//st.push(ele);
		inserAtBottom(ele);

	}
	

	public static void main(String[] args) {

		Stack<Integer> st = new Stack<>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		reverse(st);
		print(stack);

	}

}
