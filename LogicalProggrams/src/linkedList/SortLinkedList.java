package linkedList;

public class SortLinkedList {
	static Node head;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	private void push(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	private void printList(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		printList(head.next);
	}

	private void sortList() {

		Node i = head;
		Node j = null;
		int temp;
		if (head == null)
			return;

		while (i != null) {
			j = i.next;
			while (j != null) {
				if (i.data > j.data) {
					temp = i.data;
					i.data = j.data;
					j.data = temp;
				}
				j = j.next;
			}

			i = i.next;
		}

	}

	public static void main(String[] args) {
		SortLinkedList ll = new SortLinkedList();
		ll.push(5);
		ll.push(8);
		ll.push(2);
		ll.push(0);
		ll.push(3);
		ll.sortList();
		ll.printList(ll.head);
	}
}
