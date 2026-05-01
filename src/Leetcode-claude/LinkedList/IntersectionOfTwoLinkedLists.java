/*
 * LeetCode 160: Intersection of Two Linked Lists
 *
 * Problem: Given the heads of two singly linked lists headA and headB,
 * return the node at which the two lists intersect.
 * If no intersection, return null.
 *
 * Example: Input: headA = [4,1,8,4,5], headB = [5,6,1,8,4,5], intersectVal = 8
 *          Output: Node 8
 *
 * Approach: Two Pointers (No Extra Space)
 * - Both pointers traverse both lists sequentially
 * - When both lists have same length, they meet at intersection
 * - Difference in lengths is handled by traversing the longer list first
 *
 * Time Complexity: O(n + m) where n, m are lengths of lists
 * Space Complexity: O(1) - only two pointers
 */

public class IntersectionOfTwoLinkedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        // Move both pointers
        // When a reaches end, switch to headB
        // When b reaches end, switch to headA
        // If they're equal, that's the intersection
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }

    // Alternative approach using HashSet
    // Time: O(n + m), Space: O(n)
    public ListNode getIntersectionNodeHashSet(ListNode headA, ListNode headB) {
        java.util.Set<ListNode> nodes = new java.util.HashSet<>();

        while (headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists sol = new IntersectionOfTwoLinkedLists();

        // Create intersection node
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        // Create headA: 4->1->8->4->5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;

        // Create headB: 5->6->1->8->4->5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        ListNode result = sol.getIntersectionNode(headA, headB);
        System.out.println("Intersection at node: " + (result != null ? result.val : "null"));
    }
}
