package linkedList;

public class PalimdromLinkedList {

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	Node first, last;

	private void addLast(int d) {
		Node node = new Node(d);
		if (first == null) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}

	}

	private boolean isPalimdrom(Node node) {
		Node original = node;
		Node reverse = reverse(node);

		while (original != null) {
			if (original.data != reverse.data) {
				return false;
			}

			original = original.next;
			reverse = reverse.next;
		}
		return true;

	}

	private Node reverse(Node head) {
		if (head.next == null) {
			return head;
		}
		Node rest = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return rest;

	}

	private void printList(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		printList(node.next);
	}

	public static void main(String[] args) {
		PalimdromLinkedList obj = new PalimdromLinkedList();
		obj.addLast(10);
		obj.addLast(20);
		obj.addLast(30);
		obj.addLast(20);
		obj.addLast(10);
		// obj.printList(obj.first);
		//Node n = obj.reverse(obj.first);
		//obj.printList(n);
		boolean flag = obj.isPalimdrom(obj.first);
		if(flag) {
			System.out.println("The linked list is Palimdrom");
		}else {
			System.out.println("The linked list is NOT Palimdrom");
		}

	}

}
