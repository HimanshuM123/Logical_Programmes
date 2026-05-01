package leetcode2;

public class ReverseLinkedList {

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	Node first;
	Node last;

	private void addLast(int data) {
		Node node = new Node(data);
		if (first == null) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
	}

	private void printList(Node n) {
		
		while (n != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}

	}

	private Node reverseList(ReverseLinkedList ll) {
		Node head = ll.first;
		Node prev = null;

		while (head != null) {
			Node remaining = head.next;//20->30->40->50
			head.next = prev;//10->null
			prev = head;//10->null
			head = remaining;//20->30->40->50
		}

		return prev;
	}

	public static void main(String[] args) {
		ReverseLinkedList ll = new ReverseLinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);
		ll.printList(ll.first);
		System.out.println();
		Node rev = ll.reverseList(ll);
		ll.printList(rev);

	}

}
