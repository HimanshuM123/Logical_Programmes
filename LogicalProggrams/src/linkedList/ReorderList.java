package linkedList;

public class ReorderList {
	Node first, last;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
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

	private void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + "  ");
			head = head.next;
		}
	}

	private void reorderList(Node head) {
		Node slow = head;
		Node fast = head.next;
		//find middle
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node second = slow.next;
		slow.next = null;
		Node prev = null;
		//reverse second half
		while (second != null) {
			Node temp = second.next;
			second.next = prev;
			prev = second;
			second = temp;

		}
		//merge 2 halfs
		second = prev;
		first =head;
		while(second!=null) {
			Node temp1= first.next;
			Node temp2= second.next;
			first.next=second;
			second.next=temp1;
			first=temp1;
			second=temp2;
		}

	}

	private int length(Node head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	public static void main(String[] args) {
		ReorderList ll = new ReorderList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);

		//ll.printList(ll.first);
		//System.out.println(ll.length(ll.first));
		ll.reorderList(ll.first);
		ll.printList(ll.first);

	}

}

/*
 * 
 * 10 20 30 40
 * 
 * 10 40 20 30
 * 
 * 
 */

//https://www.youtube.com/watch?v=S5bfdUTrKLM&list=PLot-Xpze53leU0Ec0VkBhnf4npMRFiNcB