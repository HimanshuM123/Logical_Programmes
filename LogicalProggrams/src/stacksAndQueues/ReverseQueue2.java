package stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue2 {

	private static void reverse(Queue<Integer> queue) {

		if (queue.isEmpty()) {
			return;
		}
		int ele = queue.remove();
		reverse(queue);
		queue.add(ele);

	}

	private static void print(Queue<Integer> queue) {
		while (!queue.isEmpty()) {
			System.out.print(queue.peek() + "  ");
			queue.remove();
		}
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		reverse(queue);
		print(queue);
	}

}
