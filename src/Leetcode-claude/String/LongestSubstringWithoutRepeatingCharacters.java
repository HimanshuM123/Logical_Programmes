/*
 * LeetCode 3: Longest Substring Without Repeating Characters
 *
 * Problem: Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example: Input: s = "abcabcbb" -> Output: 3 (Explanation: "abc")
 *
 * Approach: Sliding Window with HashMap
 * - Use two pointers (left, right) to maintain a window
 * - Store character and its last seen index in HashMap
 * - When duplicate found, move left pointer to skip the previous occurrence
 *
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(min(m, n)) - where m is charset size (at most 26 for lowercase)
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If character already exists in current window, move left pointer
            if (charIndex.containsKey(ch)) {
                left = Math.max(left, charIndex.get(ch) + 1);
            }

            // Update character's latest index
            charIndex.put(ch, right);

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(sol.lengthOfLongestSubstring("au"));       // 2
        System.out.println(sol.lengthOfLongestSubstring(""));         // 0
    }
}
