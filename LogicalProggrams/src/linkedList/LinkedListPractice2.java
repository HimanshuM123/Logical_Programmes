package linkedList;

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

	// 10 20,30,40,50,60
	private void print(Node head) {
		while (head != null) {
			System.out.print(head.data + "  ");
			head = head.next;
		}
	}

	private Node reverse(Node head) {
		if (head.next == null) {
			return head;
		}

		Node rest = reverse(head.next);
		head.next.next = head;
		head.next = null;

		return rest;

	}

	private boolean isPalimdrom(Node head) {
		// Node originalList = head;
		Node rev = reverse(head);
		while (head != null) {
			if (head.data != rev.data) {
				return false;
			}

			rev = rev.next;
			head = head.next;
		}
		return true;
	}
	//10 20 30 20 10
	private int middleEle(Node head) {
		Node slow= head;
		Node fast = head;
		
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast= fast.next.next;
		}
		return slow.data;
		
	}
	
	//10 20 30 40 50 60 
	
	private Node evenList(Node head) {
		Node odd = head;
		Node even = head.next;
		
		Node evenNode = even;
		
		while(even!=null && even.next!=null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even=even.next;
		}
		
		return head;		
	}

	public static void main(String[] args) {
		LinkedListPractice2 list = new LinkedListPractice2();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);

		list.print(list.first);
		System.out.println();
		// Node rev = list.reverse(list.first);
		// list.print(rev);
		//boolean isPalim = list.isPalimdrom(list.first);
		//System.out.println(isPalim);
		int middle = list.middleEle(list.first);
		//System.out.println(middle);
		Node evenNode = list.evenList(list.first);
		list.print(evenNode);
		
	}

}
