package linkedList;


public class ReverseRecur {
	
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
        if ( head.next == null)
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
		
		ReverseRecur list = new ReverseRecur();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
	
		
		//list.printList(list);
		Node head =list.reverse(list.first);
		list.printList(head);
		
		
	}
}

/*
step1 -   10   20,30,40,50
step2 -   10   50,40,30,20 (reverse(head.next)
step3 -   10.next.next = 20  , 50,40,30,20-> 10 ( head.next.next = head)
step4 -   50,40,30,20,10-> NULL  (head.next = null)

*/