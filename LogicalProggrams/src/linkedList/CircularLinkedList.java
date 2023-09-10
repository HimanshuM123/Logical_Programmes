package linkedList;

public class CircularLinkedList {
	Node first;
	Node last;

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

	private Node makeCircular(Node head) {
		Node start = head;

		while (head.next != null) {
			head = head.next;
		}
		head.next = start;
		return start;
	}

	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.makeCircular(list.first);

	}
}
