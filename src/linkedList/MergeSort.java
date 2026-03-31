package linkedList;

public class MergeSort {
	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

		public Node() {
			// TODO Auto-generated constructor stub
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

	private void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	Node getMid(Node head) {
		Node midPrev = null;
		while (head != null && head.next != null) {
			midPrev = (midPrev == null) ? head : midPrev.next;
			head = head.next.next;
		}
		Node mid = midPrev.next;
		midPrev.next = null;
		return mid;
	}

	private Node merge(Node list1, Node list2) {
		Node dummyNode = new Node();
		Node tail = dummyNode;
		while (list1 != null && list2 != null) {
			if (list1.data < list2.data) {
				tail.next = list1;
				list1 = list1.next;
				tail = tail.next;
			} else {
				tail.next = list2;
				list2 = list2.next;
				tail = tail.next;
			}
		}
		tail.next = (list1 != null) ? list1 : list2;
		return dummyNode.next;

	}

	private Node sortList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node mid = getMid(head);
		Node left = sortList(head);
		Node right = sortList(mid);
		return merge(left, right);

	}

	public static void main(String[] args) {
		MergeSort obj = new MergeSort();
		obj.addLast(10);
		obj.addLast(50);
		obj.addLast(20);
		obj.addLast(40);
		obj.addLast(30);

		obj.printList(obj.first);
//		Node mid_ele = obj.getMid(obj.first);
//		System.out.println();
//		System.out.println("The Middle element is " + mid_ele.data);
		System.out.println();
		Node sortedList = obj.sortList(obj.first);
		obj.printList(sortedList);
	}

}
