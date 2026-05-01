package practice2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueTest {
	public static void main(String[] args) {

		Queue<Integer> queue = new LinkedList();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);

		Queue result = reverse(queue);
		printList(result);

	}

	private static Queue reverse(Queue<Integer> queue) {
		Stack<Integer> st = new Stack<>();
		while (!queue.isEmpty()) {
			st.add(queue.remove());
		}

		while (!st.isEmpty()) {
			queue.add(st.pop());
		}

		return queue;

	}

	private static void printList(Queue<Integer> queue) {
		while (!queue.isEmpty()) {
			System.out.print(queue.remove() + "  ");
		}

	}

}
