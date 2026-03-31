package linkedList;

public class Reverse2 {

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	Node first, last;

	private void addLast(int d) {
		Node node = new Node(d);
		if (first == null) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
	}
	
	private void print(Node head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
		}
	}
	//10 ->20->30-> 40-> 50-> 60 
	private Node reverse(Node head) {
		Node prev = null;
		while(head!=null) {
			Node next_node = head.next;
			head.next=prev;
			prev=head;
			head=next_node;
		}
		return prev;
		
	}

	public static void main(String[] args) {
		Reverse2 list = new Reverse2();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.print(list.first);
		System.out.println("=======================");
		list.print(list.reverse(list.first));

	}

}
