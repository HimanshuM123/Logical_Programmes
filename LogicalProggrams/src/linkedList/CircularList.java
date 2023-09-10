package linkedList;

public class CircularList {

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

	private boolean isCircular(Node head) {
		Node slow = head;
		Node fast = head.next;
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;

	}

	public static void main(String[] args) {
		CircularList list = new CircularList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);

		list.first.next.next.next.next.next = list.first;
		boolean result = list.isCircular(list.first);
		if (result) {
			System.out.println("The list is circular");
		} else {
			System.out.println("The list is NOT circular");
		}
	}

}
