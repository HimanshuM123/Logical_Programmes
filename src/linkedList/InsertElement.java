package linkedList;

public class InsertElement {

	private static class Node {
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

	private void print(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	private void insertFirst(int d) {
		Node new_node = new Node(d);
		new_node.next = first;
		first = new_node;
	}

	private Node insertAfter(Node head, int data, int position) {
		Node new_node = new Node(data);
		if (position == 0) {
			new_node.next = head;
			return new_node;
		}
		int i = 0;
		Node temp = head;
		while (i < position) {
			temp = temp.next;
			i++;
		}
		new_node.next = temp.next;
		temp.next = new_node;

		return head;

	}

	public static void main(String[] args) {
		InsertElement obj = new InsertElement();
		obj.addLast(1);
		obj.addLast(2);
		obj.addLast(3);
		obj.addLast(4);
		obj.addLast(5);
		obj.print(obj.first);
		System.out.println();//1 2 3 4 5 
		obj.insertFirst(0);
		obj.print(obj.first);
		System.out.println();//0 1 2 3 4 5 
		Node result = obj.insertAfter(obj.first, 9, 3);
		obj.print(result);//0 1 2 3 9 4 5

	}

}

/*

0 1 2 3 4 5
0 1 2 3  traverse
9 -> null -- 4->5  new_node.next = temp.next;
9->4->5

0->1->2->3 ->9->4-> temp.next = new_node;
*/