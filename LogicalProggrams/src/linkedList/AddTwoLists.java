package linkedList;

import java.util.Stack;

public class AddTwoLists {

	private static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	Node first, firstLast;
	Node second, secondLast;

	private void addLast3(int d) {
		Node node = new Node(d);
		if (first == null) {
			first = firstLast = node;
		}
		firstLast.next = node;
		firstLast = node;

	}

	private void addLast4(int d) {
		Node node = new Node(d);
		if (second == null) {
			second = secondLast = node;
		}
		secondLast.next = node;
		secondLast = node;

	}

	private void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	public static Node addTwoNumbers(Node firstHead, Node secondHead)
	{
	    Stack<Integer> stack1 = new Stack<>();
	    Stack<Integer> stack2 = new Stack<>();
	 
	    Node l1 = firstHead;
	    Node l2 = secondHead;
	    while (l1 != null)
	    {
	        stack1.add(l1.data);
	        l1 = l1.next;
	    }
	 
	    while (l2 != null) 
	    {
	        stack2.add(l2.data);
	        l2 = l2.next;
	    }
	 
	    int carry = 0;
	    Node result = null;
	 
	    /*
	     	5 3 1 
			6 8 2 
			-----
		  1 2 1 3  
	     */
	    while (!stack1.isEmpty() ||
	           !stack2.isEmpty()) 
	    {
	        int a = 0, b = 0;
	 
	        if (!stack1.isEmpty()) 
	        {
	            a = stack1.pop();
	        }
	 
	        if (!stack2.isEmpty()) 
	        {
	            b = stack2.pop();
	        }
	 
	        int total = a + b + carry;
	 
	        Node temp = new Node(total % 10);
	        carry = total / 10;
	 
	        if (result == null) 
	        {
	            result = temp;
	        }
	        else
	        {
	            temp.next = result;
	            result = temp;
	        }
	    }
	 
	    if (carry != 0)
	    {
	        Node temp = new Node(carry);
	        temp.next = result;
	        result = temp;
	    }
	    return result;
	}

	
	public static void main(String[] args) {
		AddTwoLists ll = new AddTwoLists();
		ll.addLast3(5);
		ll.addLast3(3);
		ll.addLast3(1);

		ll.addLast4(6);
		ll.addLast4(8);
		ll.addLast4(2);
		ll.printList(ll.first);
		System.out.println();
		ll.printList(ll.second);
		Node result = ll.addTwoNumbers(ll.first, ll.second);
		System.out.println();
		System.out.println("-----");
		ll.printList(result);
//		System.out.println();
//		System.out.println("The result is ");
//		ll.printList(result.first);
	}



}
