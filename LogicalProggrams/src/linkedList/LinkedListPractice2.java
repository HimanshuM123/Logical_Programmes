package linkedList;

import java.util.Stack;

public class LinkedListPractice2 {

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

	private void print(Node head) {
		while (head != null) {
			System.out.print(head.data + "  ");
			head = head.next;
		}
	}

	private int printMiddle(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	// 10 20 30 40 50
	private Node reverseList(Node head) {
		if (head.next == null) {
			return head;
		}

		Node rest = reverseList(head.next);
		head.next.next = head;
		head.next = null;

		return rest;

	}
	// 10 20 30 20 10
	private boolean isPalimdrom(Node head) {
		Stack<Integer> stk = new Stack<>();
		Node head2  =head;
		while(head!=null) {
			stk.push(head.data);
			head=head.next;
		}
		while(head2!=null) {
			int d = stk.pop();
			if(d !=head2.data) {
				return false;
			}	
			head2=head2.next;
		}
		return true;
	}

	public static void main(String[] args) {
		LinkedListPractice2 list = new LinkedListPractice2();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(20);
		list.addLast(10);
		list.print(list.first);
		// System.out.println("Middle emelent----");
		// System.out.println(list.printMiddle(list.first));
		System.out.println("===================================");
		//Node rev = list.reverseList(list.first);
		//list.print(rev);
		System.out.println(list.isPalimdrom(list.first));

	}
//10  20  30  40  50  
}
