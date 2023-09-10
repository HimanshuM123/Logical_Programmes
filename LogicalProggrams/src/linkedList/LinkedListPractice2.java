package linkedList;

public class LinkedListPractice2 {
	Node head;

	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static void main(String[] args) {
		LinkedListPractice2 list = new LinkedListPractice2();
		list.head = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		list.head.next = node2;
		node2.next = node3;
		node3.next = node4;
		list.addFirst(5);
		list.addLast(6);
		list.removeFirst();
		list.removeLast();
		list.printList();

	}
	
	private void printList() {
		Node node=head;
		while(node!=null) {
			System.out.print(node.data+" ");
			node=node.next;
		}// 1 2 3 4
	}
	
	private void addFirst(int ele) {
		Node element=new Node(ele);
		element.next=head;
		head=element;
	}

	private void addLast(int ele) {
		Node node=head;
		Node element=new Node(ele);
		while(node !=null && node.next!=null) {
			node=node.next;
		}
		node.next=element;
	}
	private void removeFirst() {
		Node node=head;
		head=node.next;
		node.next=null;
		
	}
	private void removeLast() {
		Node node=head;
		while(node !=null && node.next.next!=null) {
			node=node.next;
		}
		node.next=null;
	}

}
