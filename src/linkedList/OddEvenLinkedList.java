package linkedList;

public class OddEvenLinkedList {
	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	Node first, last;

	private void printList(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + "   ");
		printList(node.next);

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

	private Node oddEvenList(Node head) {
		if (head == null) {
			return null;
		}

		Node odd = head;
		Node even = head.next;
		Node evenHead = even;
//1  2  3  4  5 
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;

	}

	public static void main(String[] args) {
		OddEvenLinkedList list = new OddEvenLinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.printList(list.first);
		Node result = list.oddEvenList(list.first);
		System.out.println();
		list.printList(result);
	}

}
// output -> 1   3   5   2   4 