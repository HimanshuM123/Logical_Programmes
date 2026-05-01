package linkedList;

public class MergeTwoSortedList {
	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	Node first, firstLast;
	Node second, secondLast;

	private void addLast1(int d) {
		Node node = new Node(d);
		if (first == null) {
			first = firstLast = node;
		}
		firstLast.next = node;
		firstLast = node;

	}

	private void addLast2(int d) {
		Node node = new Node(d);
		if (second == null) {
			second = secondLast = node;
		}
		secondLast.next = node;
		secondLast = node;

	}

	private void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	private MergeTwoSortedList merge(Node first, Node second) {
		MergeTwoSortedList ans = new MergeTwoSortedList();
		while (first != null && second != null) {
			if (first.data < second.data) {
				ans.addLast1(first.data);
				first = first.next;
			} else {
				ans.addLast1(second.data);
				second = second.next;
			}
		}

		while (first != null) {

			ans.addLast1(first.data);
			first = first.next;

		}
		while (second != null) {

			ans.addLast1(second.data);
			second = second.next;

		}
		return ans;

	}

	public static void main(String[] args) {
		MergeTwoSortedList ll = new MergeTwoSortedList();
		ll.addLast1(1);
		ll.addLast1(3);
		ll.addLast1(5);

		ll.addLast2(2);
		ll.addLast2(4);
		ll.addLast2(6);
		ll.printList(ll.first);
		System.out.println();
		ll.printList(ll.second);
		MergeTwoSortedList result =ll.merge(ll.first, ll.second);
		System.out.println();
		System.out.println("The result is ");
		ll.printList(result.first);
	}

}
