/*
 * LeetCode 19: Remove Nth Node From End of List
 *
 * Problem: Given the head of a linked list, remove the nth node from the end of the list
 * and return the head of the list.
 *
 * Example: Input: head = [1,2,3,4,5], n = 2 -> Output: [1,2,3,5]
 *
 * Approach: Two Pointers with Dummy Node
 * - Use dummy node to handle edge case of removing head
 * - First pointer moves n steps ahead
 * - Then both pointers move until first reaches end
 * - Remove the node by adjusting pointers
 *
 * Time Complexity: O(L) where L is length of list - two passes, but constant iterations
 * Space Complexity: O(1) - only pointers
 */

public class RemoveNthNodeFromEndOfList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node
        second.next = second.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList sol = new RemoveNthNodeFromEndOfList();

        // Create: 1->2->3->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Remove 2nd node from end (which is 4)
        ListNode result = sol.removeNthFromEnd(head, 2);

        // Print: 1->2->3->5
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }
}
