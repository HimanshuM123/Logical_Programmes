package leetcode2;

public class LinkedListPalimdrom {
	Node first;
	Node last;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	private void addLast(int data) {
		Node node = new Node(data);
		if(first == null) {
			first = last = node;
		}else {
			last.next= node;
			 last=node;
		}
	}
	
	private void printList(LinkedListPalimdrom ll ) {
		Node node = ll.first;
		while(node!=null) {
			System.out.print(node.data+"->");
			node = node.next;
		}
	}
	//10->20->30->20->10
	private static boolean isPalimdrome(Node head) {
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next!=null) {
			fast = fast.next.next;//10-> null
			slow = slow.next;// 30 ->20->10
		}
		slow=reverse(slow);
		while(slow !=null) {
			if (slow.data !=head.data) {
				return false;
			}
			slow=slow.next;
			head=head.next;
		}
		return true;
	}
	
	private  static Node reverse(Node head) {
		Node prev =null;
		while(head !=null) {
			Node remaining = head.next; //20->30->40
			head.next = prev; //10->null
			prev = head;    //10->null
			head = remaining; // 20->30->40
		}
		return prev;
	}

	public static void main(String[] args) {
		LinkedListPalimdrom ll = new LinkedListPalimdrom();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(20);
		ll.addLast(10);
		//ll.printList(ll);
	    boolean val = isPalimdrome(ll.first);
	    if(val) {
	    	System.out.println("The linkedlist is palimdrom");
	    }else {
	    	System.out.println("The linkedlist is NOT palimdrom");
	    }
	}

}
