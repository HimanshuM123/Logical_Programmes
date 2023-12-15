package linkedList;

//RemoveDuplicates from sorted linked list
public class RemoveDuplicatesSortedList {
	private static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
	
	Node first , last;
	private void addLast(int d) {
		Node node = new Node(d);
		if(first == null) {
			first = last = node;
		}else {
			last.next =node;
			last = node;
		}
	}
	
	private void print(Node head) {
		while(head!= null) {
			System.out.print(head.data+" ");
			head = head .next;
		}
	}
	// 10  20  20  30  30
	private Node removeDuplicates(Node head) {
		Node curr = head;
		
		while(curr.next!=null) {
			if(curr.data == curr.next.data) {
				curr.next= curr.next.next;
			}else {
				curr = curr.next;	
			}		
		}
		
		return head;
	}
	public static void main(String[] args) {
		RemoveDuplicatesSortedList obj = new RemoveDuplicatesSortedList();
		obj.addLast(10);
		obj.addLast(20);
		obj.addLast(20);
		obj.addLast(30);
		obj.addLast(30);
		obj.print(obj.first);
		System.out.println();
		Node result = obj.removeDuplicates(obj.first);
		obj.print(result);
		
		
	}

}
