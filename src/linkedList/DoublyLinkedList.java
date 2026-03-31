package linkedList;

public class DoublyLinkedList {
	static Node head;

	private class Node {
		int data;
		Node next, prev;

		Node(int data) {
			this.data = data;
		}
	}

	private void push(int d) {
		Node node = new Node(d);
		node.next = head;
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}

		head = node;
	}
	
	private int size(Node head) {
		if(head==null) return 0;
		int size = size(head.next)+1;
		return size;
		
	}

	public static void main(String[] args) {
		DoublyLinkedList dl = new DoublyLinkedList();
		dl.push(40);
		dl.push(30);
		dl.push(20);
		dl.push(10);
		System.out.println("The size is "+dl.size(dl.head));

	}

	
}

/*
	      ->  ->  ->   -> NULL
	     10  20   30  40
    NULL<-   <-  <-   <-

*/