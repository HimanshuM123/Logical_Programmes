/*
 * LeetCode 387: First Unique Character in a String
 *
 * Problem: Given a string s, find the first non-repeating character in it and return its index.
 * If no such character exists, return -1.
 *
 * Example: Input: s = "leetcode" -> Output: 0
 *          Input: s = "loveleetcode" -> Output: 2
 *
 * Approach: Two Pass with HashMap
 * - First pass: count frequency of each character
 * - Second pass: find first character with frequency 1
 *
 * Time Complexity: O(n) - two passes through string
 * Space Complexity: O(1) - HashMap size at most 26 (lowercase letters)
 */

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        // Count frequency of each character
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    // Alternative using array for lowercase letters
    // Time: O(n), Space: O(1) - fixed size array of 26
    public int firstUniqCharArray(String s) {
        int[] charCount = new int[26];

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInString sol = new FirstUniqueCharacterInString();

        System.out.println(sol.firstUniqChar("leetcode"));       // 0
        System.out.println(sol.firstUniqChar("loveleetcode"));   // 2
        System.out.println(sol.firstUniqChar("aabb"));           // -1
        System.out.println(sol.firstUniqChar("abc"));            // 0
    }
}
