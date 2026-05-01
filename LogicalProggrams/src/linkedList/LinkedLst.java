package linkedList;

public class LinkedLst {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void printList() {
		Node node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	// add at the begining
	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public static void main(String[] args) {
		LinkedLst list = new LinkedLst();
		list.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		list.head.next = second;
		second.next = third;
		list.push(4);

		list.printList();

	}

}
