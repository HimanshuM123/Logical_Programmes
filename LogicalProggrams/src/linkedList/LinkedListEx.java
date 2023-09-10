package linkedList;



public class LinkedListEx {
	
	private class Node {
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
		}
	}
	
	private Node first;
	private Node last;
	
	private void addLast(int val) {
		Node node = new Node(val);
		if (first == null) {
			first = last = node;
		}else {
			last.next= node;
			last = node; 
			
		}
		
	}
	
	private static void printList(LinkedListEx list) {
		Node n = list.first;
		while(n!=null) {
			System.out.println(n.data+" ");
			n=n.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListEx list = new LinkedListEx();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		printList(		list);
	}

}
