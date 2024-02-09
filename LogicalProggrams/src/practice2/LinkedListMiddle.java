package practice2;

public class LinkedListMiddle {

	Node first, last;
	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
	
	private void addLast(int d) {
		Node node = new Node(d);
		if(first == null) {
			first = last =node;
		}else {
			last.next =node;
			last = node;
		}
		
	}
	
	private void printList(Node node) {
		while(node != null) {
			System.out.println(node.data+" ");
			node = node.next;
		}
	}
	
	
	public static void main(String[] args) {
		LinkedListMiddle ll = new LinkedListMiddle();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);
		ll.printList(ll.first);
	}
}
