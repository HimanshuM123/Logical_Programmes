package linkedList;

public class LinkedListPractice {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			this.data = d;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		LinkedListPractice list = new LinkedListPractice();                // list
		list.head = new Node(1);                                          //    data=1
		Node second = new Node(2);                                       //        next -> data=2
		Node third = new Node(3);                                       //                    next -> data=3
		Node fourth = new Node(4);                                     //                                next -> data=4
                                                                      //                                           next -> null
		list.head.next = second;
		second.next = third;
		third.next = fourth;
		
		list.printList();
		list.deleteNode(3);
		System.out.println();
		list.printList();
		

	}
	
	public  void printList() {
		Node n= head;
		while(n!=null) {
			System.out.print(n.data+" ");
			n=n.next;
		}
	}
	
	public void deleteNode(int key) {
		// Store head node
        Node temp = head, prev = null;
 
       if(temp!=null && temp.data==key) {
    	   head=temp.next;
       }
       
       while(temp!=null && temp.data!=key) {
    	   prev=temp;
    	   temp=temp.next;
    	  // System.out.println(prev.data);
       }
       while(temp==null) {
    	   return;
       }
       prev.next=temp.next;
	}

}
