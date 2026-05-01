/*
 * LeetCode 23: Merge K Sorted Lists
 *
 * Problem: You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example: Input: lists = [[1,4,5],[1,3,4],[2,6]]
 *          Output: [1,1,2,1,3,4,4,5,6]
 *
 * Approach: Min Heap (Priority Queue)
 * - Add all list heads to min heap
 * - Poll minimum node, add it to result
 * - If it has next node, add next to heap
 * - Continue until heap is empty
 *
 * Time Complexity: O(n * k * log k) where n is total nodes, k is number of lists
 * Space Complexity: O(k) for heap
 */

import java.util.PriorityQueue;
import java.util.List;

public class MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min heap based on node value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add all heads to heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            // Get node with minimum value
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;

            // Add next node to heap if exists
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists sol = new MergeKSortedLists();

        // Create lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode result = sol.mergeKLists(new ListNode[]{list1, list2, list3});

        // Print: 1->1->2->1->3->4->4->5->6
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }
}
