package dataStructure;

public class LinkedLst1 {
	Node head;
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data=d;
			next=null;
		}
		
	}
	
	
	
	public void push(int new_data) {
		Node newNode=new Node(new_data);
		newNode.next=head;
		head=newNode;
	}
	
	public void printList() {
		Node node=head;
		while(node!=null) {
			System.out.print(node.data+" ");
			node=node.next;
		}
	}
	
	public int getCount() {
		Node node=head;
		int count=0;
		while(node!=null) {
			count++;
			node=node.next;
		}
		return count;
	}
	
	 void removeDuplicates()
	    {
	        /*Another reference to head*/
	        Node curr = head;
	 
	        /* Traverse list till the last node */
	        while (curr != null) {
	             Node temp = curr;
	            /*Compare current node with the next node and 
	            keep on deleting them until it matches the current 
	            node data */
	            while(temp!=null && temp.data==curr.data) {
	                temp = temp.next;
	            }
	            /*Set current node next to the next different 
	            element denoted by temp*/
	            curr.next = temp;
	            curr = curr.next;
	        }
	    }
	
	
	public static void main(String[] args) {
		
		LinkedLst1 list=new LinkedLst1();
		for(int i=5;i>0;i--) {
			list.push(i);
		}
		list.push(5);
		list.push(5);
		list.printList();
		int size=list.getCount();
		System.out.println("The size of linkedlist is "+size);
		
		list.removeDuplicates();
		list.printList();
		
	}

}
