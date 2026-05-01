package linkedList;

public class ReversePrint {

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
	
	Node first , last;
	
	private void addLast(int d) {
		Node node = new Node(d);
		if(first ==  null ) {
			first = last = node;
		}
		last.next = node;
		last = node;
		
	}
	
	private void reverse(Node head) {
		if(head== null) {
			return;
		}
		
		reverse(head.next);
		System.out.print(head.data+" ");
	}
	
	private void printList(Node head) {
		while(head != null) {
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		ReversePrint obj = new ReversePrint();
		obj.addLast(10);
		obj.addLast(20);
		obj.addLast(30);
		obj.addLast(40);
		obj.addLast(50);
		//obj.printList(obj.first);
		obj.reverse(obj.first);
	}

}
