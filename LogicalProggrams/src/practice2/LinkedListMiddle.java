package practice2;

public class LinkedListMiddle {
	Node first;
	Node last;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	private void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	private void printMiddle(Node head) {
		Node slow_ptr = null;
		Node fast_ptr = null;
		
		slow_ptr= fast_ptr=head;

		while (fast_ptr != null && fast_ptr.next != null) {
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
		}
		System.out.println("Middle element is " + slow_ptr.data);
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

	public static void main(String[] args) {
		LinkedListMiddle ll = new LinkedListMiddle();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);
		//ll.printList(ll.first);
		ll.printMiddle(ll.first);
	}
}
