package linkedList;

import concepts.MainMethod;

public class AlternateElements {
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
		if (head == null) {
			return;
		}
		System.out.print(head.data+" ");
		print(head.next);
	}
	
	private Node getAlternate(Node head) {
		Node original =head;
		while(head.next.next!= null) {
			head.next = head.next.next;
			head=head.next;
		}
		return original;
		
	}

	public static void main(String[] args) {
		AlternateElements obj = new AlternateElements();
		obj.addLast(10);
		obj.addLast(20);
		obj.addLast(30);
		obj.addLast(40);
		obj.addLast(50);
		obj.addLast(60);
		obj.addLast(70);
		obj.addLast(80);
	//	obj.print(obj.first);
		Node result = obj.getAlternate(obj.first);
		obj.print(result);
		
	}

}
