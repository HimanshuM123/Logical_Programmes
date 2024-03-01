package linkedList;

import java.util.HashSet;
import java.util.Set;


//RemoveDuplicates from sorted linked list
public class RemoveDuplicates {

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
		System.out.print(head.data + "-> ");
		printList(head.next);
	}

	private Node removeDuplicates(Node head) {

		Set<Integer> set = new HashSet<>();
		Node curr = head;
		Node prev = null;

		while (curr != null) {
			if (set.contains(curr.data)) {
				prev.next = curr.next;
			} else {
				set.add(curr.data);
				prev = curr;
			}
			curr = curr.next;
		}
		return head;
	}

	public static void main(String[] args) {
		RemoveDuplicates d = new RemoveDuplicates();
//		d.push(66);
//		d.push(66);
//		d.push(66);
//		d.push(55);
//		d.push(55);
//		d.push(11);
//		d.push(11);
//		d.push(11);
		d.push(4);
		d.push(3);
		d.push(3);
		d.push(3);
		d.push(2);
		d.push(1);
		//d.printList(d.head);
		d.removeDuplicates(d.head);
		d.printList(d.head);

	}

}
/*
prev= curr
prev= 1,2,3,3,3,4   curr=2,3,3,3,4
prev= 2,3,3,3,4   curr= 3,3,3,4
prev= 3,3,3,4   curr= 3,3,4
prev.next= curr.next
prev= 3,3,4   curr= 3,4
prev= 3,4   curr= 4 ->NULL
prev= 4   curr= NULL


*/