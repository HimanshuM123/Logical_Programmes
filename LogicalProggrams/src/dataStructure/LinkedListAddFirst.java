package dataStructure;

public class LinkedListAddFirst {
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
		if(first ==  null) {
			first = last = node;
		}else {
			last.next = node;
			last = node;
		}
	}
	
	private void addFirst(int d) {
		Node node = new Node(d);
		node.next=first;
		first=node;
	}
	
	private void printList(Node head) {
		while(head!=null) {
			System.out.print(head.data+"  ");
			head= head.next;
		}
		
	}
	
	public static void main(String[] args) {
		LinkedListAddFirst ll = new LinkedListAddFirst();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addFirst(100);
		ll.printList(ll.first);
	}

}
