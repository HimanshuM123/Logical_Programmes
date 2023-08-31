package dataStructure;

public class LinkedListSizeRecur {

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
	
	private void print(Node head) {
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	private void printRecur(Node head) {
		if(head == null) {
			return ;
		}
		
		System.out.print(head.data+" ");
		printRecur(head.next);
	}
	private int size(Node head) {
		if(head==null) {
			return 0;
		}
		int size = 1+ size(head.next);
		return size;
	}

	public static void main(String[] args) {
		LinkedListSizeRecur list = new LinkedListSizeRecur();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.printRecur(list.first);
		int size = list.size(list.first);
		System.out.println("The size is "+size);
	}

}
