/*
 * LeetCode 141: Linked List Cycle
 *
 * Problem: Given head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached
 * again by continuously following the next pointer.
 *
 * Example: Input: head = [3,2,0,-4], pos = 1 -> Output: true (cycle exists)
 *
 * Approach: Floyd's Cycle Detection (Tortoise and Hare)
 * - Use two pointers: slow (1 step), fast (2 steps)
 * - If they meet, cycle exists
 * - If fast reaches null, no cycle
 *
 * Time Complexity: O(n) - if no cycle O(n), if cycle O(n + k) where k is steps before meeting
 * Space Complexity: O(1) - only two pointers
 */

public class LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // Move 1 step
            fast = fast.next.next;      // Move 2 steps

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false;
    }

    // Find the start of the cycle (LeetCode 142)
    public ListNode detectCycleStart(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Found cycle, now find start
                ListNode ptr1 = head;
                ListNode ptr2 = slow;

                while (ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }

                return ptr1; // Start of cycle
            }
        }

        return null;
    }

    public static void main(String[] args) {
        LinkedListCycle sol = new LinkedListCycle();

        // Create cycle: 3->2->0->-4->2
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode nodeNeg4 = new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = nodeNeg4;
        nodeNeg4.next = node2; // Creates cycle

        System.out.println(sol.hasCycle(head));                    // true
        System.out.println(sol.detectCycleStart(head).val);        // 2

        // No cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(sol.hasCycle(head2));                   // false
    }
}
