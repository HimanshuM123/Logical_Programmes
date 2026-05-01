/*
 * LeetCode 21: Merge Two Sorted Lists
 *
 * Problem: You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list.
 * The list should be made by splicing together the nodes of the two lists.
 *
 * Example: Input: list1 = [1,2,4], list2 = [1,3,4]
 *          Output: [1,1,2,3,4,4]
 *
 * Approach: Two Pointers Merge
 * - Compare nodes from both lists
 * - Attach smaller node to result
 * - Move pointer of list from which node was taken
 * - Attach remaining nodes at end
 *
 * Time Complexity: O(n + m) where n, m are lengths of lists
 * Space Complexity: O(1) - reusing existing nodes, no extra space
 */

public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists sol = new MergeTwoSortedLists();

        // Create list1: 1->2->4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Create list2: 1->3->4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode merged = sol.mergeTwoLists(list1, list2);

        // Print: 1->1->2->3->4->4
        while (merged != null) {
            System.out.print(merged.val + " -> ");
            merged = merged.next;
        }
        System.out.println("null");
    }
}
