package dataStructure;

public class LinkedListLength {

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

	}
	private Node first;
	private Node last;
	
	private void addLast(int val) {
		Node node = new Node(val);
		if(first == null) {
			first = last = node;
		}
		else {
			last.next = node;
			last = node;
		}
		
	}
	
	private void printList(LinkedListLength ll ) {
		Node n =ll.first;
		while(n!=null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	private int length(LinkedListLength ll ) {
		Node n = ll.first;
		int count =0;
		while(n!=null) {
			count++;
			n = n.next;
		}
		return count;
	}
	
	public static void main(String[] args) {
		LinkedListLength ll = new LinkedListLength();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		System.out.println("The length of Linked list is "+ll.length(ll));
	}

}
