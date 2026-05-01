package leetcode2;

public class LinkedListMiddle {
	//Node head;
	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
	
	Node first ,last ;
	private void addLast(int d) {
		Node n = new Node(d);
		if(first ==null) {
			first = last = n;
		}else {
			last .next = n;
			last =n;
		}
	}
	
	private void printlist(LinkedListMiddle ll) {
		Node  node= ll.first;
		while(node!=null) {
		System.out.print(node.data+" ");
		node=node.next;
		}
		
	}
	
	private int findMiddle(LinkedListMiddle ll) {
		Node head =ll.first;
		Node slow_ptr = head;
		Node fast_ptr =head;
		
		while(fast_ptr!=null && fast_ptr.next!=null) {
			slow_ptr = slow_ptr.next;
			fast_ptr=fast_ptr.next.next;
		}
		return slow_ptr.data;
		
		
	}
// 10,20,30,40,50
	public static void main(String[] args) {
		LinkedListMiddle ll = new LinkedListMiddle();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);
		ll.printlist(ll);
		int middle = ll.findMiddle(ll);
		System.out.println();
		System.out.print("Middle element is "+middle);
	}
}
