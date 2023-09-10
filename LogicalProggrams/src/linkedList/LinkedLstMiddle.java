package linkedList;

public class LinkedLstMiddle {
	
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
		
		Node new_node=new Node(new_data);
		new_node.next=head;
		
		head=new_node;
		
	}
	void printMiddle() {
		Node slow_ptr=head;
		Node fast_ptr=head;
		
		if(head!=null) {
			while(fast_ptr!=null && fast_ptr.next!=null) {
				fast_ptr=fast_ptr.next.next;
				slow_ptr=slow_ptr.next;
			}
			System.out.println("The middle element is "+slow_ptr.data);
			
		}
		
	}
	
	public static void main(String[] args) {
		LinkedLstMiddle linkedList=new LinkedLstMiddle();
		for(int i=5;i>0;--i) {
			linkedList.push(i);
		}
		linkedList.printMiddle();
	}

}
