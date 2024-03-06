package practice2;

public class PracticeLinkedList {
	private static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
	
	Node first ,last;
	
	private void addLast(int d) {
		Node node = new Node(d);
		if(first == null) {
			first = last = node;
		}else {
			last.next=node;
			last = node;
		}
	}
	
	private void print(Node head) {
		if(head==null) {
			return;
		}
		
		System.out.print(head.data+" ");
		print(head.next);
		
	}
	
	private Node addBegining(Node head, int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head=new_node;
		return head;
	}
	
	private Node addEnd(Node head, int new_data) {
		Node new_node = new Node(new_data);
		Node original= head;
		while(head.next!=null) {
			head = head.next;
		}
		head.next=new_node;
		return original;
	}
	
	private Node addAtPosition(Node head, int new_data, int position) {
		Node new_node = new Node(new_data);
		Node temp= head;
		int i=0;
		while(i< position) {
			temp = temp.next;
			i++;
		}
		Node temp2 =temp.next;
		temp.next=new_node;
		new_node.next = temp2;
		return head;
		
	}
	
	public static void main(String[] args) {
		PracticeLinkedList obj = new PracticeLinkedList();
		obj.addLast(10);
		obj.addLast(20);
		obj.addLast(30);
		obj.addLast(40);
		obj.addLast(50);
		
		obj.print(obj.first);
		Node result = obj.addBegining(obj.first, 90);
		System.out.println();
		obj.print(result);
		System.out.println();
		obj.print(obj.addEnd(obj.first, 80));
		System.out.println();
		Node result2= obj.addAtPosition(obj.first, 70, 2);
		obj.print(result2);
		
	}

}
