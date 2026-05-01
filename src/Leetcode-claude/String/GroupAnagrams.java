/*
 * LeetCode 49: Group Anagrams
 *
 * Problem: Given an array of strings strs, group the anagrams together.
 *
 * Example: Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *          Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
 *
 * Approach 1: Sort Characters (Used here)
 * - For each string, sort its characters to get a canonical form
 * - Use HashMap with sorted string as key
 * - All anagrams have the same sorted form
 *
 * Time Complexity: O(n * k log k) where n is number of strings, k is max length of a string
 * Space Complexity: O(n * k) for storing all characters in map
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Sort characters to get canonical form
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // Add string to its anagram group
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(str);
        }

        return new ArrayList<>(map.values());
    }

    // Alternative Approach: Use character count as key
    // Time: O(n * k) where k is max string length
    // Space: O(n * k)
    public List<List<String>> groupAnagramsOptimized(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getCharCountKey(str);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String getCharCountKey(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                sb.append((char)('a' + i)).append(count[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();

        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(sol.groupAnagrams(strs1));

        String[] strs2 = {""};
        System.out.println(sol.groupAnagrams(strs2));

        String[] strs3 = {"a"};
        System.out.println(sol.groupAnagrams(strs3));
    }
}
