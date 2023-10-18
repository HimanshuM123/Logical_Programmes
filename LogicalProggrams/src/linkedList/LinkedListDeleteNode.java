package linkedList;

public class LinkedListDeleteNode {
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

	private void print(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
	}

	private void deleteNode(Node head, int d) {
		while (head.next != null) {
			if (head.next.data == d) {
				head.next = head.next.next;
			}
			head = head.next;
		}

	}
//10->20->30->40->30->50
	public static void main(String[] args) {
		LinkedListDeleteNode ll = new LinkedListDeleteNode();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(30);
		ll.addLast(50);
		// ll.print(ll.first);
		 System.out.println();
		 ll.deleteNode(ll.first, 30);
		ll.print(ll.first);
	}
	/*
	10->20->30->40->50
	      |    |
	       --->
*/
}
