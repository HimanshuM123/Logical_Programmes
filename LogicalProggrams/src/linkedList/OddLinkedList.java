package linkedList;

public class OddLinkedList {

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
			first = last = node;
		}else {
			last.next=node;
			last = node;
		}
	}
	
	private void print(Node head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head= head.next;
		}
	}
	// 1  2  3  4  5
	private Node oddList(Node head) {
		if(head == null) {
			return null;
		}
		
		Node odd = head;
		Node even= head.next;
		Node evenHead = even;
		while(even!=null && even.next!=null) {
			odd.next= even.next;
			odd=odd.next;
			even.next= odd.next;
			even=even.next;
		}
		return head;
	}
	
	Node first, last;
	public static void main(String[] args) {
		OddLinkedList ll = new OddLinkedList();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		
		//ll.print(ll.first);
		Node oddList = ll.oddList(ll.first);
		ll.print(oddList);
	}

}
