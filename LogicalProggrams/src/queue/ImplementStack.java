package queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStack {

	static class Stack {

		static Queue<Integer> q1 = new LinkedList<Integer>();
		static Queue<Integer> q2 = new LinkedList<Integer>();
		static int curr_size;

		static void push(int x) {
			// Push x first in empty q2
			q2.add(x);

			// Push all the remaining
			// elements in q1 to q2.
			while (!q1.isEmpty()) {
				q2.add(q1.peek());
				q1.remove();
			}

			// swap the names of two queues
			Queue<Integer> q = q1;
			q1 = q2;
			q2 = q;
		}

		static int size() {
			return q1.size();
		}

	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println("current size: " + s.size());
	}
}
