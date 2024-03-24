package linkedList;



public class MergeSortedList2 {
	Node first, last;
	Node first2, last2;
	private class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}	
	}
	private void printList(Node head) {
		while(head!=null) {
			System.out.print(head.data+"  ");
			head = head.next;
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
	
	private void addLast2(int d) {
		Node node = new Node(d);
		if(first2 == null) {
			first2 = last2 = node;
		}else {
			last2.next=node;
			last2=node;
		}
	}
	
	private Node mergeList(Node l1, Node l2) {
		Node dummy = new Node(-1);
		Node curr = dummy;
		while (l1 != null && l2 != null) {
			if (l1.data < l2.data) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		if (l1 != null) {
			curr.next = l1;
			l1 = l1.next;
		}

		if (l2 != null) {
			curr.next = l2;
			l2 = l2.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		MergeSortedList2 ll = new MergeSortedList2();
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(4);
		ll.addLast(5);
		ll.addLast(6);
		
		ll.printList(ll.first);
		
		ll.addLast2(1);
		ll.addLast2(2);
		ll.addLast2(3);
		System.out.println();
		ll.printList(ll.first2);
		
		Node result = ll.mergeList(ll.first, ll.first2);
		System.out.println();
		ll.printList(result);
	}

}
/*

1  2  4  5  6  
1  2  3  
1  1  2  2  3  4  5  6  


*/