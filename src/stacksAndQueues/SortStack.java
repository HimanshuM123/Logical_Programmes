package stacksAndQueues;

import java.util.Stack;

public class SortStack {

	public static Stack<Integer> sortstack(Stack<Integer> input) {
		Stack<Integer> tmpStack = new Stack<Integer>();
		while (!input.isEmpty()) {
			int in = input.pop();
			while (!tmpStack.isEmpty() && tmpStack.peek() < in) {
				input.push(tmpStack.pop());
			}
			tmpStack.push(in);
		}
		return tmpStack;
	}

	private static void print(Stack<Integer> st) {
		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}

	public static void main(String[] args) {
		Stack<Integer> input = new Stack<Integer>();
		input.add(4);
		input.add(3);
		input.add(2);
		input.add(1);
		Stack<Integer> result =	sortstack(input);
		print(result);
		//print(input);

	}

}


//output -> 1 2 3 4 