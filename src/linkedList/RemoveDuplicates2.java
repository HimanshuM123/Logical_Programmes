package linkedList;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates2 {
	Node first, last;
	Node first2, last2;

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	private void addLast(int d) {
		Node node = new Node(d);
		if (first == null) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
	}

	private void addLast2(int d) {
		Node node = new Node(d);
		if (first2 == null) {
			first2 = last2 = node;
		} else {
			last2.next = node;
			last2 = node;
		}
	}

	private void printList(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		printList(node.next);
	}

	private Node removeDuplicates(Node node) {
		Set<Integer> set = new LinkedHashSet<>();

		while (node != null) {
			set.add(node.data);
			node = node.next;
		}
		for (Integer o : set) {
			addLast2(o);
		}
		return first2;
	}

	public static void main(String[] args) {
		RemoveDuplicates2 obj = new RemoveDuplicates2();
		obj.addLast(8);
		obj.addLast(3);
		obj.addLast(6);
		obj.addLast(8);
		obj.addLast(3);
		obj.addLast(9);
		 obj.printList(obj.first);
		 System.out.println();
		Node result = obj.removeDuplicates(obj.first);
		obj.printList(result);
	}

}
