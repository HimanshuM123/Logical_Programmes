package dataStructure;

import java.util.NoSuchElementException;

public class LinkedList {
	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

	}

	private Node first;
	private Node last;

	public void addLast(int item) {
		Node node = new Node(item);

		if (first == null) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
	}

	public void addFirst(int item) {
		Node node = new Node(item);

		if (first == null) {
			first = last = node;
		} else {
			node.next = first;
			first = node;
		}
	}

	public int indexOf(int item) {
		int index = 0;
		Node current = first;
		while (current != null) {
			if (current.value == item) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}

	public boolean contains(int item) {
		Node current = first;

		while (current != null) {
			if (current.value == item)
				return true;

			current = current.next;

		}
		return false;

	}

	public void removeFirst() {
		// 10 -> 20 -> 30
		if (first == null)
			throw new NoSuchElementException();
		if (first == last) {
			first = last = null;
			return;
		}

		Node second = first.next;
		first.next = null;
		first = second;

	}

	public void removeLast() {
		if (first == null)
			throw new NoSuchElementException();
		
		if (first == last) {
			first = last = null;
			return;
		}
		
		Node previous = getPreviousNode(last);
		last = previous;
		last.next = null;
	}

	private Node getPreviousNode(Node node) {
		Node current = first;
		while (current != null) {
			if (current.next == node)
				return current;

			current = current.next;

		}
		return null;
	}
	
	private static void printList(LinkedList list) {
		Node n = list.first;
		while(n!=null) {
			System.out.println(n.value+" ");
			n=n.next;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addFirst(40);
		// System.out.println(list.indexOf(30));
		// System.out.println(list.contains(40));
		//list.removeFirst();
		//list.removeLast();
		printList(list);
		
	}

}
