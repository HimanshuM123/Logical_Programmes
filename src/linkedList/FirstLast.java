package linkedList;


public class FirstLast {
	private class Node{
		int data;
		Node next;
		Node(int data) {
			this.data= data;
		}
	}
	Node first , last ;
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
/*	
	private Node firstLast(Node head) {
		if(head==null) {
			return null;
		}
		Node temp = head;
		
		while(head.next!=null) {
			head= head.next;
		}
		temp.next=head;
		
		return temp;
		
	}
	*/
	// 1  2  3  4  5  6  
	private Node firstLast(Node head) {
		if(head==null) {
			return null;
		}
		Node temp = head;
		
		while(temp.next!=null) {
			temp= temp.next;
		}
		head.next=temp;
		
		return head;
		
	}
	
	public static void main(String[] args) {
		FirstLast ll = new FirstLast();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(3);
		ll.addLast(4);
		ll.addLast(5);
		ll.addLast(6);
		
		
		Node result = ll.firstLast(ll.first);
		ll.printList(result);
	}

}
// output -> 1 6 