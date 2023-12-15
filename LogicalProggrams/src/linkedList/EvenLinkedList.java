package linkedList;

public class EvenLinkedList {
	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
	Node first, last ;
	private void addLast(int d) {
		Node node = new Node(d);
		if(first ==null) {
			first = last = node;
		}else {
			last.next= node;
			last= node;
		}
	}
	
	private void printList(Node head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head= head.next;
		}
		
	}
	// 1 2 3 4 5 6
	private Node evenList(Node head) {
		if(head==null) {
			return null;
		}
		
		Node odd= head;
		Node even=head.next;
		Node evenHead = even;
		while(even!=null && even.next!=null) {
			odd.next=even.next;
			odd =odd.next;
			even.next=odd.next;
			even=even.next;
		}
		
		return evenHead;
		
	}
	
	public static void main(String[] args) {
		EvenLinkedList ll = new EvenLinkedList();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		ll.addLast(6);
		Node even = ll.evenList(ll.first);
		ll.printList(even);
		
	}

}
