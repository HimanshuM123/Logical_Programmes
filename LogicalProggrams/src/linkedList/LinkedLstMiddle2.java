package linkedList;

public class LinkedLstMiddle2 {
	Node head;

	private class Node{
		
		int data;
		Node next;
		Node(int data){
			this.data=data;
		}
	}
	
	private void push(int newData) {
		Node node = new Node(newData);
		node.next = head;
		head = node;
	}
	
	private void printMiddle(LinkedLstMiddle2 list ) {
	Node fast_ptr =  head;
	Node slow_ptr = head;
	if (null!= head) {
		while(fast_ptr != null && fast_ptr.next !=null) {
			
			fast_ptr = fast_ptr.next.next;
			slow_ptr = slow_ptr.next;
		
		}
		System.out.println("The Middle element is "+slow_ptr.data);
	}
		
		
	}
	
	//0->1->2->3->4
	public static void main(String[] args) {
		LinkedLstMiddle2 list = new LinkedLstMiddle2();
		for(int i=0;i<5;i++) {
			list.push(i);
		}
		list.printMiddle(list);
	}
}
