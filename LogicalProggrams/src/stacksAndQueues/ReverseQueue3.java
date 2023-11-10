package stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue3 {
	
	private static void print(Queue<Integer> queue ) {
		while(!queue.isEmpty()) {
			System.out.print(queue.remove()+" ");
		}
	}
	
	private static Queue reverse(Queue<Integer> queue ) {
		Stack<Integer> st = new Stack<Integer>();
		while(!queue.isEmpty()) {
			st.push(queue.remove());
		}
		
		while(!st.isEmpty()) {
			queue.add(st.pop());
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
		//print(queue);
		Queue result = reverse(queue);
		print(result);
	}

}
