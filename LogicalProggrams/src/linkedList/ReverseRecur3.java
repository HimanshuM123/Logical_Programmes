package linkedList;

public class ReverseRecur3 {
	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
	Node first , last ;
	
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
			head=head.next;
		}
		
	}
	
	private void reverse(Node node) {
		if(node == last) {  //reach at the end of linkedlist
			first = last;
			return;
		}
		reverse(node.next);
		last.next=node;
		last = node;
		last.next=null;
		
	}
	
	public static void main(String[] args) {
		ReverseRecur3 ll = new ReverseRecur3();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);
		ll.print(ll.first);
		ll.reverse(ll.first);
		System.out.println("\n Reversed list is ");
		ll.print(ll.first);
	}

}



/*
10->20->30->40->50 

10->20->30->40<-50 
		last.next=node;  40 <- 50
		last = node;     last = 40;
		last.next=null;   40 -> null

*/