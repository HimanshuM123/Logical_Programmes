/*
 * LeetCode 206: Reverse Linked List
 *
 * Problem: Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example: Input: 1->2->3->4->5 -> Output: 5->4->3->2->1
 *
 * Approach: Iterative with Three Pointers
 * - prev: tracks the reversed part
 * - curr: current node being reversed
 * - next: temporarily store next node before breaking link
 *
 * Time Complexity: O(n) - visit each node once
 * Space Complexity: O(1) - only pointers, no extra space
 */

public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // Iterative Approach
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // Store next node
            ListNode next = curr.next;

            // Reverse the link
            curr.next = prev;

            // Move prev and curr one step forward
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Recursive Approach
    // Time: O(n), Space: O(n) for recursion stack
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next);

        // Reverse the link between head and head.next
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList sol = new ReverseLinkedList();

        // Create: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversed = sol.reverseList(head);

        // Print: 5->4->3->2->1
        while (reversed != null) {
            System.out.print(reversed.val + " -> ");
            reversed = reversed.next;
        }
        System.out.println("null");
    }
}
