package linkedList;

public class LinkedList5 {
	Node first, last;
	private class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}	
	}
	
	private void addLast(int d) {
		Node node = new Node(d);
		if(first == null) {
			first = last = node;
		}else {
			last.next=node;
			last=node;
		}
	}
	
	private void printList(Node head) {
		while(head!=null) {
			System.out.print(head.data+"  ");
			head = head.next;
		}
	}
	
	private int length(Node head) {
		int count =0;
		while(head!=null) {
			count++;
			head=head.next;
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		LinkedList5 ll = new LinkedList5();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		
		ll.printList(ll.first);
		System.out.println(ll.length(ll.first));
		
	}
	

}
