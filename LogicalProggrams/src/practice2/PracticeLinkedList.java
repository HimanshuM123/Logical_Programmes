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
	
	private Node reverse(Node head) {
		if(head.next ==null) {
			return head;
		}
		
		Node rest = reverse(head.next);
		head.next.next =head;
		head.next=null;
		
		return rest;
		
	}
	
	private boolean isPalimdrom(Node head) {
		
		Node rev = reverse(head);
		while(head!=null) {
			if(head.data!=rev.data) {
				return false;
			}
			head=head.next;
			rev=rev.next;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		PracticeLinkedList obj = new PracticeLinkedList();
		obj.addLast(10);
		obj.addLast(20);
		obj.addLast(30);
		obj.addLast(20);
		obj.addLast(10);
		
		obj.print2(obj.first);
		System.out.println();
		
		Node reverse = obj.reverse(obj.first);
		System.out.println();
		obj.print(reverse);
		
		boolean res = obj.isPalimdrom(obj.first);
	System.out.println(res);
		

	}
	// 10 20 20 30 30

}
