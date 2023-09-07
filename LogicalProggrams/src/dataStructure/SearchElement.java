package dataStructure;

public class SearchElement {
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

	private boolean isExists(int data, Node head) {
		while (head != null) {
			if (head.data == data) {
				return true;
			}
			head = head.next;
		}
		return false;

	}

	public static void main(String[] args) {
		SearchElement s = new SearchElement();
		s.addLast(10);
		s.addLast(20);
		s.addLast(30);
		boolean flag = s.isExists(30, s.first);
		if (flag) {
			System.out.println("The given element exists");
		} else {
			System.out.println("The given element does NOT exist");
		}

	}

}
