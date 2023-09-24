package linkedList;


public class LinkedListReverseRecur {
	
	private Node first= null;
	private Node last = null;
	
	private static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
		}
	}
	
	private void addLast(int d) {
		Node node = new Node(d);
		if(first == null) {
			first = last = node;
		}
		else {
			last.next= node;
			last = node;
		}
	}
	
	private void printList(Node first  ) {
		Node n =first;
		while(n!=null) {
			System.out.print(n.data+" ");
			n = n.next;
		}
	}
	
	private  Node reverse(Node head)  {
        if (head == null || head.next == null)
            return head;
 
        /* reverse the rest list and put
        the first element at the end */
        Node rest = reverse(head.next);
        head.next.next = head;
 
        
        /* tricky step -- see the diagram */
        head.next = null;
 
        /* fix the head pointer */
        return rest;
    }
	public static void main(String[] args) {
		
		LinkedListReverseRecur list = new LinkedListReverseRecur();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		//list.printList(list);
		Node head =list.reverse(list.first);
		list.printList(head);
		
		
	}

}
