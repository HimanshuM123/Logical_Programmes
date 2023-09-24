package practice2;

public class Practice {
	
	private class Node {
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
		
	}
	
	Node first, last;
	
	private void addLast(int d) {
		Node node = new Node(d);
		if(first == null) {
			first = last = node;
		}else {
			last.next=node;
			last = node;
		}
		
	}
	
	private boolean isPalimdrom(Node head) {
		Node slow_ptr =head;
		Node fast_ptr =head;
		
		while(fast_ptr!=null && fast_ptr.next!=null) {
			slow_ptr= slow_ptr.next;
			fast_ptr=fast_ptr.next.next;
		}
		
		slow_ptr = reverse(slow_ptr);
		
		while(slow_ptr.next!=null) {
			if(slow_ptr.data != head.data) {
				return false;
			}
			slow_ptr = slow_ptr.next;
			head= head.next;
		}
		
		return true;
		
		
	}
	// 10, 20,30 ,40 ,50
	
	private Node reverse(Node head) {
		if(head==null || head.next==null) {
			return head;
		}
		
		Node rest = reverse(head.next);
		head.next.next=head;
		head.next=null;
		
		return rest;
		
	}
	
	private void printList(Node head) {
		if(head==null) {
			return;
		}
		System.out.print(head.data+" ");
		printList(head.next);	
	}

	
	public static void main(String[] args) {
		Practice p = new Practice();
		p.addLast(1);
		p.addLast(2);
		p.addLast(3);
		p.addLast(2);
		p.addLast(1);
		
		p.printList(p.first);
		
		boolean result = p.isPalimdrom(p.first);
		System.out.println(result);
		
	}

}
