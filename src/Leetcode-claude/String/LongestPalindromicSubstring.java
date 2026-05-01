/*
 * LeetCode 5: Longest Palindromic Substring
 *
 * Problem: Given a string s, return the longest palindromic substring in s.
 *
 * Example: Input: s = "babad" -> Output: "bab" or "aba"
 *
 * Approach: Expand Around Center
 * - For each character (or pair of characters), treat it as center and expand outward
 * - Track the longest palindrome found
 * - Two cases: odd length (single center) and even length (two centers)
 *
 * Time Complexity: O(n^2) - for each center, expand up to n/2
 * Space Complexity: O(1) - only store indices, no extra data structures
 */

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            // Check for odd length palindromes (single character center)
            int len1 = expandAroundCenter(s, i, i);
            // Check for even length palindromes (two character center)
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            // Update longest palindrome if current is longer
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return length of palindrome (right - left - 1)
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();

        System.out.println(sol.longestPalindrome("babad"));       // "bab" or "aba"
        System.out.println(sol.longestPalindrome("cbbd"));        // "bb"
        System.out.println(sol.longestPalindrome("racecar"));     // "racecar"
        System.out.println(sol.longestPalindrome("a"));           // "a"
        System.out.println(sol.longestPalindrome("abcdef"));      // "a" (any single char)
    }
}
