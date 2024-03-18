package practice2;

import java.util.HashSet;
import java.util.Set;

public class PracticeLinkedList {
	private static class Node {
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
	
	private void print(Node node) {
		while(node!= null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	
	private void print2(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data+" ");
		print2(node.next);
	}
	
	private Node insertFirst(Node node, int d) {
		Node ele = new Node(d);
		ele.next = node;
		return ele;
	}
	

	public static void main(String[] args) {
		PracticeLinkedList obj = new PracticeLinkedList();
		obj.addLast(10);
		obj.addLast(20);
		obj.addLast(30);
		obj.addLast(40);
		obj.addLast(50);
		obj.addLast(60);

		obj.print2(obj.first);
		Node result = obj.insertFirst(obj.first,5);
		System.out.println();
		obj.print2(result);
		

	}
	// 10 20 20 30 30

}
