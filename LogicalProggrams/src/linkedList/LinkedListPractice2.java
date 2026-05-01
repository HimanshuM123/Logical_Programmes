package linkedList;

import java.util.Stack;

public class LinkedListPractice2 {
	Node first , last;
	private class Node{
		int data;
		Node next;
		Node(int data){
			this.data =data;
		}
	}
	
	private void addLast(int d) {
		Node node = new Node(d);
		if(first == null) {
			first = last = node;
		}else{
			last.next = node;
			last=node;
		}
		//10->null
	}
	
	private void print(Node head) {
		while(head!=null) {
			System.out.println(head.data+" ");
			head = head.next;
		}
	}
	
	private int middle(Node head) {
		Node fast =head;
		Node slow =head;
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.data;
		
		
	}

	
	public static void main(String[] args) {
		
		LinkedListPractice2 obj = new LinkedListPractice2();
		obj.addLast(10);
		obj.addLast(20);
		obj.addLast(30);
		obj.addLast(40);
		obj.addLast(50);
		obj.addLast(60);
		obj.addLast(70);
		int result = obj.middle(obj.first);
		//obj.print(obj.first);
		System.out.println(result);
		
		
	}

}
