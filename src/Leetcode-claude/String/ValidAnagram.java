/*
 * LeetCode 242: Valid Anagram
 *
 * Problem: Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An anagram is a word formed by rearranging the letters of another word.
 *
 * Example: Input: s = "anagram", t = "nagaram" -> Output: true
 *
 * Approach: Character Count
 * - Option 1: Sort both strings and compare
 * - Option 2: Use array/map to count characters in both strings
 *
 * Time Complexity: O(n) - count characters (or O(n log n) if sorting)
 * Space Complexity: O(1) - fixed size array of 26 (assuming lowercase)
 */

public class ValidAnagram {

    // Approach 1: Using array for character count
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];

        // Count characters in s
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Subtract characters in t
        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }

        // All counts should be 0
        for (int count : charCount) {
            if (count != 0) return false;
        }

        return true;
    }

    // Approach 2: Using sorting
    // Time: O(n log n), Space: O(1)
    public boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        java.util.Arrays.sort(sArray);
        java.util.Arrays.sort(tArray);

        return java.util.Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();

        System.out.println(sol.isAnagram("anagram", "nagaram"));      // true
        System.out.println(sol.isAnagram("rat", "car"));              // false
        System.out.println(sol.isAnagram("a", "a"));                  // true
        System.out.println(sol.isAnagram("ab", "ba"));                // true
        System.out.println(sol.isAnagram("hello", "world"));          // false
    }
}
