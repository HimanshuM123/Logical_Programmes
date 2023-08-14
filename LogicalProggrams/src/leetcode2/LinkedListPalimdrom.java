package leetcode2;

public class LinkedListPalimdrom {
	Node first;
	Node last;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	private void addLast(int data) {
		Node node = new Node(data);
		if(first == null) {
			first = last = node;
		}else {
			last.next= node;
			 last=node;
		}
	}
	
	private void printList(LinkedListPalimdrom ll ) {
		Node node = ll.first;
		while(node!=null) {
			System.out.print(node.data+"->");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		LinkedListPalimdrom ll = new LinkedListPalimdrom();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.printList(ll);
	
	}

}
