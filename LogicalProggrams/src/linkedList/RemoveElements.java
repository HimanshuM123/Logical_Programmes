package linkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveElements {
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

	private void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "  ");
			head = head.next;
		}
	}

	private Node removeEle(Node head, int d) {
		Node curr = head;
		Node prev = null;
		while (curr != null) {
			if (curr.data == d) {
				prev.next = curr.next;
			} else {
				prev = curr;
			}
			curr = curr.next;
		}
		return head;
	}

	public static void main(String[] args) {
		RemoveElements ll = new RemoveElements();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(6);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		ll.addLast(6);

		ll.printList(ll.first);
		Node result = ll.removeEle(ll.first, 6);
		System.out.println();
		ll.printList(result);

	}

}
