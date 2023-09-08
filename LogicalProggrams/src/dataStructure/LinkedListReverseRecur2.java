package dataStructure;

public class LinkedListReverseRecur2 {
	Node first;
	Node last;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
	
	private void print(Node head) {
		while(head != null) {
			System.out.print(head.data +" ");
			head = head.next;
		}
	}

	private void addLast(int d) {
		Node node = new Node(d);
		if (first == null) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
	}
	
	private Node reverse(Node currentNode, Node nextNode) {
		Node ret;
		if(currentNode == null) {
			return null;
		}
		if(currentNode.next == null) {
			currentNode.next =  nextNode;
			return currentNode;
		}
		ret = reverse(currentNode.next,currentNode);
		currentNode.next =  nextNode;
		return ret;
	}

	public static void main(String[] args) {
		LinkedListReverseRecur2 ll = new LinkedListReverseRecur2();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.print(ll.first);
		System.out.println();
		Node rev = ll.reverse(ll.first, null);
		ll.print(rev);
	}

}
