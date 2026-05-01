package linkedList;

public class PalimdromLinkedList2 {

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	Node first, last;

	private void addLast(int d) {
		Node node = new Node(d);
		if (first == null) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}

	}

//	private boolean isPalimdrom(Node node) {
//		Node original = node;
//		Node reverse = reverse(node);
//
//		while (original != null) {
//			if (original.data != reverse.data) {
//				return false;
//			}
//
//			original = original.next;
//			reverse = reverse.next;
//		}
//		return true;
//
//	}

	
	 public boolean isPalimdrom(Node head) {
         Node original = head;
       
         System.out.println();
        Node rev = reverse(head);
      
       
        while(original!= null){
            if(rev.data != original.data){
                return false;
            }
            rev= rev.next;
            original=original.next;
        }

        return true;
        
    }
	 private Node reverse(Node node){
         if(node==null){
             return null;
         }
         if(node.next == null){
             return node;
         }
        Node rest = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return rest;

    }

	private void printList(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		printList(node.next);
	}

	public static void main(String[] args) {
		PalimdromLinkedList2 obj = new PalimdromLinkedList2();
		obj.addLast(1);
		obj.addLast(1);
		obj.addLast(2);
		obj.addLast(1);
	
		// obj.printList(obj.first);
		//Node n = obj.reverse(obj.first);
		//obj.printList(n);
		boolean flag = obj.isPalimdrom(obj.first);
		if(flag) {
			System.out.println("The linked list is Palimdrom");
		}else {
			System.out.println("The linked list is NOT Palimdrom");
		}

	}

}
