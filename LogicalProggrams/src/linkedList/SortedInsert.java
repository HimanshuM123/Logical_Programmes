package linkedList;

public class SortedInsert {

	Node first;
	Node last;

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
			last.next= node;
			last=node;
		}
	}
	
	private void print(Node head) {
		while(head!= null) {
			System.out.println(head.data+" ");
			head= head.next;
		}
	}
	
	private void sortedInsert(int data, Node head) {
		Node node = new Node(data);
		Node newNode =null;
		while(head.next!=null && head.next.data<data) {
			newNode= head;
			head=head.next;
		//	newNode.next=null;
			
			//newNode.next=head;
		}
		node.next =head.next;
		head.next = node;
	}
	
	public static void main(String[] args) {
		SortedInsert s = new SortedInsert();
		s.addLast(10);
		s.addLast(20);
		s.addLast(40);
		s.addLast(50);
		s.print(s.first);
		s.sortedInsert(30, s.first);
	}

}

// 10->20->40->50   30
// output 10->20->30->40->50