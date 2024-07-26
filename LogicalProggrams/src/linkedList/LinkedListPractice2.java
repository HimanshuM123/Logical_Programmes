package linkedList;

import java.util.Stack;

public class LinkedListPractice2 {

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

		while (head != null) {
			System.out.print(head.data + " ->");
			head = head.next;
		}
	}

	private boolean isPalimdrom(Node head) {
		Node original = head;

		Stack<Integer> stk = new Stack<>();
		while (head != null) {
			stk.push(head.data);
			head = head.next;
		}

		while (!stk.isEmpty()) {
			if (original.data != stk.pop()) {
				return false;
			}
			original = original.next;
		}

		return true;
	}
	// 10,20,30,40,50
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
	
	private Node alternate(Node head) {
		Node alternate = head;
		
		while(head.next.next!=null) {
			
			head.next=head.next.next;
			head=head.next;
		}
		
		
		return alternate;
		
	}

	public static void main(String[] args) {
		LinkedListPractice2 list = new LinkedListPractice2();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		//list.print(list.first);

		//boolean result = list.isPalimdrom(list.first);
		//System.out.println(result);
		
		System.out.println();
		//list.print(list.reverse(list.first));
		System.out.println();
		Node res = list.alternate(list.first);
		list.print(res);

	}

}
