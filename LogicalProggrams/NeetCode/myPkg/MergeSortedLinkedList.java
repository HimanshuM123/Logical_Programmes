package myPkg;

public class MergeSortedLinkedList {
	private class Node {
		int data;
		Node next;

		Node() {

		}

		Node(int data) {
			this.data = data;
		}
	}

	Node first1, last1;
	Node first2, last2;

	private void addLast1(int d) {
		Node node = new Node(d);
		if (first1 == null) {
			first1 = last1 = node;
		} else {
			last1.next = node;
			last1 = node;

		}
	}
	private void addLast2(int d) {
		Node node = new Node(d);
		if (first2 == null) {
			first2 = last2 = node;
		} else {
			last2.next = node;
			last2 = node;

		}
	}
	
	private void print(Node head) {
		while(head!=null) {
			System.out.print(head.data +"-> ");
			head = head.next;
		}
	}
	
	private Node merge(Node head1,Node head2) {
		
		Node dummy;
		Node node = new Node();
		dummy=node;
		
		while(head1!= null && head2!=null) {
			if(head1.data < head2.data) {
				node.next= head1;
				head1 = head1.next;
			}else  {
				node.next= head2;
				head2 = head2.next;
			}
			node = node.next;
		}
		node.next = (head1!=null) ? head1:head2;
		return dummy.next;
		
	}

	public static void main(String[] args) {
		MergeSortedLinkedList list = new MergeSortedLinkedList();
		list.addLast1(1);
		list.addLast1(2);
		list.addLast1(4);
		list.print(list.first1);
		System.out.println();
		list.addLast2(1);
		list.addLast2(3);
		list.addLast2(5);
		list.print(list.first2);
		
		Node result = list.merge(list.first1, list.first2);
		System.out.println();
		list.print(result);
		
	}

}
