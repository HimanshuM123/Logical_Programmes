/*
 * LeetCode 234: Palindrome Linked List
 *
 * Problem: Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Example: Input: head = [1,2,2,1] -> Output: true
 *          Input: head = [1,2] -> Output: false
 *
 * Approach: Find Middle + Reverse + Compare
 * 1. Use slow-fast pointers to find middle
 * 2. Reverse second half
 * 3. Compare first half with reversed second half
 * 4. Restore the list (optional)
 *
 * Time Complexity: O(n) - find middle O(n/2), reverse O(n/2), compare O(n/2)
 * Space Complexity: O(1) - only pointers, no extra space
 */

public class PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle using slow-fast pointers
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverseList(slow);

        // Step 3: Compare first half with reversed second half
        ListNode first = head;
        ListNode second = secondHalf;

        while (second != null) { // second half is shorter or equal
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        PalindromeLinkedList sol = new PalindromeLinkedList();

        // Create: 1->2->2->1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        System.out.println(sol.isPalindrome(head1)); // true

        // Create: 1->2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.println(sol.isPalindrome(head2)); // false

        // Create: 1->2->3->2->1
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(2);
        head3.next.next.next.next = new ListNode(1);

        System.out.println(sol.isPalindrome(head3)); // true
    }
}
