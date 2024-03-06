package practice2;

import java.util.HashSet;
import java.util.Set;

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
	private Node removeDuplicate(Node head) {
		Node curr = head;
		Node prev=null;
		Set<Integer> set = new HashSet<>();
		while(curr!= null) {
			if(set.contains(curr.data)) {
				prev.next=curr.next;
			}else {
				set.add(curr.data);
				prev= curr;
			}
			curr = curr.next;
		}
		return head;
	}
	
	
	
	public static void main(String[] args) {
		PracticeLinkedList obj = new PracticeLinkedList();
		obj.addLast(10);
		obj.addLast(20);
		obj.addLast(20);
		obj.addLast(30);
		obj.addLast(30);
		obj.addLast(20);
		
		obj.print(obj.first);
		Node result = obj.removeDuplicate(obj.first);
		System.out.println();
		obj.print(result);
		
		
		
	}
	// 10 20 20 30 30

}
