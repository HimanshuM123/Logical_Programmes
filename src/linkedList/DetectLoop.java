package linkedList;

public class DetectLoop {
	static Node head;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	private void push(int d) {
		Node node = new Node(d);
		node.next = head;
		head = node;

	}

	private boolean detectLoop(Node head) {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;

	}
	
	private int lengthOfLopp(Node head) {
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) {
				Node temp =slow;
				int length=0;
				do {
					temp=temp.next;
					length++;
				}while(temp!=slow);
				return length;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		DetectLoop loop = new DetectLoop();

		loop.push(10);
		loop.push(20);
		loop.push(30);
		loop.push(40);
		 loop.head.next.next.next.next = loop.head;

		if (loop.detectLoop(head)) {
			System.out.println("Loop Found");
	
		}
		else {
			System.out.println("Loop NOT  Found");
		}
		
		int length= loop.lengthOfLopp(head);
		System.out.println("The length of loop is "+length); //4
	}

}


/*

40 -> 30 -> 20 -> 10 
^                 |
|                 |
-------------------

*/