package practice2;

import java.util.HashSet;
import java.util.Set;

public class LinkedListDelete {

	Node head;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	private void push(int d) {
		Node node = new Node(d);
		node.next = head;
		head = node;
	}

	private void printList(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + "  ");
		printList(head.next);
	}

	private void removeDuplicate(Node head) {
		Node curr = head;
		Node prev = null;
		Set<Integer> set = new HashSet<>();
		while(curr != null) {
			if(set.contains(curr.data)) {
				prev.next=  curr.next;
			}else {
				set.add(curr.data);
				prev= curr;
			}
			
			curr= curr.next;
		}
		
	}
	
	
	public static void main(String[] args) {
		LinkedListDelete ll = new LinkedListDelete();
		ll.push(40);
		ll.push(40);
		ll.push(20);
		ll.push(20);
		ll.push(10);
		
		ll.removeDuplicate(ll.head);
		ll.printList(ll.head);
	}

}
