package linkedList;

public class LinkedListDeleteHead {
	Node first;
	Node last;
	private class Node {
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
		}
	}
	
	private void addLast(int n) {
		Node node = new Node(n);
		if(first == null) {
			first = last = node;
		}else {
			last.next = node;
			last = node;
		}		
	}
	
	private void print(Node head) {
		while(head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	
	private Node deleteHead(Node head) {
		head=head.next;
		return head;
		
	}
	
	public static void main(String[] args) {
		LinkedListDeleteHead ll = new LinkedListDeleteHead();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		//ll.print(ll.first);
		Node n =ll.deleteHead(ll.first);
		ll.print(n);
		
	}

}
