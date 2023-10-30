package stacksAndQueues;


import java.util.Queue;
import java.util.Stack;

import java.util.LinkedList;

public class ReverseQueue {
	private static void print(Queue<Integer> queue) {
		while (!queue.isEmpty()) {
			System.out.print(queue.peek() + "  ");
			queue.remove();
		}
	}

	private static Queue reverse(Queue<Integer> queue) {
		Stack<Integer> st = new Stack<>();
		while (!queue.isEmpty()) {
			st.push(queue.peek());
			queue.remove();
		}
		while (!st.isEmpty()) {
			queue.add(st.peek());
			st.pop();
		}
		return queue;
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		Queue<Integer> result = reverse(queue);
		print(result);
	}

}
