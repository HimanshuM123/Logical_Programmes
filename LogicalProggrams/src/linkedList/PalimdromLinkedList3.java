package linkedList;

import java.util.Stack;

public class PalimdromLinkedList3 {
	Node first, last;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	private void addLast(int d) {
		Node node = new Node(d);
		if (first == null) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
	}

	private boolean isPalimdrome(Node head) {
		Stack<Integer> stk = new Stack<>();
		Node original = head;
		while (head != null) {
			stk.push(head.data);
			head = head.next;
		}

		while (!stk.isEmpty()) {
			if (stk.pop() != original.data) {
				return false;
			}
			original = original.next;
		}
		return true;

	}

	private void print(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		PalimdromLinkedList3 obj = new PalimdromLinkedList3();
		obj.addLast(10);
		obj.addLast(20);
		obj.addLast(30);
		obj.addLast(50);
		obj.addLast(10);

		obj.print(obj.first);
		boolean result = obj.isPalimdrome(obj.first);

		if (result) {
			System.out.println("The list is palimdrome");
		} else {
			System.out.println("The list is NOT palimdrome");
		}

	}

}
