/*
 * LeetCode 131: Palindrome Partitioning
 *
 * Problem: Given a string s, partition s such that every substring of the partition
 * is a palindrome. Return all possible palindrome partitioning of s.
 *
 * Example: Input: s = "nitin"
 *          Output: [["n","i","t","i","n"],["n","iti","n"]]
 *
 * Approach: Backtracking
 * - At each position, try all possible ending positions
 * - If substring from current to ending is palindrome, include it
 * - Recursively partition the rest
 * - Backtrack and try other partitions
 *
 * Time Complexity: O(2^n * n) - 2^n partitions, each takes O(n) to create
 * Space Complexity: O(n) - recursion depth
 */

import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        // Base case: reached end of string
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try all possible ending positions
        for (int end = start; end < s.length(); end++) {
            // If substring is palindrome, include it
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));

                backtrack(s, end + 1, current, result);

                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning sol = new PalindromePartitioning();

        System.out.println(sol.partition("aab"));
        // [["a","a","b"],["aa","b"]]

        System.out.println(sol.partition("a"));
        // [["a"]]

        System.out.println(sol.partition("nitin"));
    }
}
