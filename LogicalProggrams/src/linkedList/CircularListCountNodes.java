package linkedList;

public class CircularListCountNodes {
	Node first;
	Node last;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	private void addLast(int data) {
		Node node = new Node(data);
		if (first == null) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
	}

	private int count(Node head) {
		int count = 1;
		Node temp = head;
		head = head.next;
		while (temp != head) {
			count++;
			head = head.next;
		}
		return count;
	}

	public static void main(String[] args) {
		CircularListCountNodes cl = new CircularListCountNodes();
		cl.addLast(10);
		cl.addLast(20);
		cl.addLast(30);
		cl.addLast(40);
		cl.first.next.next.next.next = cl.first;
		int result = cl.count(cl.first);
		System.out.println("The count is "+result);
	}

}

// 10 -> 20 -> 30 -> 40 -> 50
// ^
// |                       |
// -------------------------