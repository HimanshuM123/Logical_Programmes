/*
 * LeetCode 328: Odd Even Linked List
 *
 * Problem: Given the head of a singly linked list, group all nodes with odd indices together
 * followed by nodes with even indices, and return the new head.
 * The relative order within each group should remain as it was in the input.
 * Note: First node is considered odd (index 1), second is even (index 2), etc.
 *
 * Example: Input: head = [1,2,3,4,5]
 *          Output: [1,3,5,2,4]
 *
 * Approach: Two Pointers with Separate Lists
 * - Maintain two lists: one for odd indices, one for even indices
 * - Separate nodes into two lists
 * - Connect odd list's tail to even list's head
 *
 * Time Complexity: O(n) - single pass through list
 * Space Complexity: O(1) - reusing existing nodes
 */

public class OddEvenLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;

        ListNode current = head.next.next;
        int index = 3; // Start from 3rd node (1-indexed)

        while (current != null) {
            if (index % 2 == 1) {
                // Odd index
                oddTail.next = current;
                oddTail = oddTail.next;
            } else {
                // Even index
                evenTail.next = current;
                evenTail = evenTail.next;
            }

            current = current.next;
            index++;
        }

        // Connect odd list to even list
        oddTail.next = evenHead;
        evenTail.next = null; // Important: set last node's next to null

        return oddHead;
    }

    public static void main(String[] args) {
        OddEvenLinkedList sol = new OddEvenLinkedList();

        // Create: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = sol.oddEvenList(head);

        // Print: 1->3->5->2->4
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }
}
