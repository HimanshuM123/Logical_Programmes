package linkedList;

import java.util.Stack;

public class LinkedListPractice2 {

	private class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	Node first , last;
	
	private void addLast(int d) {
		Node node = new Node(d);
		if(first ==null) {
			first = last = node;
		}else {
			last.next =node;
			last = node;
		}
	}
	
	private void print(Node head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head = head.next;
			
		}
	}
	
	
	
	public static void main(String[] args) {
		
		LinkedListPractice2 obj = new LinkedListPractice2();
		obj.addLast(10);
		obj.addLast(20);
		obj.addLast(20);
		obj.addLast(30);
		obj.addLast(30);
		obj.addLast(30);
		
		obj.print(obj.first);
		
		
	}

}
