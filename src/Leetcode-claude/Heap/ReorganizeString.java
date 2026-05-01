/*
 * LeetCode 767: Reorganize String
 *
 * Problem: Given a string s, rearrange it such that no two adjacent characters are the same.
 * If this is not possible, return an empty string.
 *
 * Example: Input: s = "abbaca" -> Output: "ababac"
 *
 * Approach: Max Heap
 * - Count frequency of each character
 * - Use max heap to always pick character with highest frequency
 * - Alternate between current and previous character to avoid adjacent duplicates
 * - If at any point we can't place a character, return empty string
 *
 * Time Complexity: O(n log k) where k is alphabet size (26)
 * Space Complexity: O(1) - fixed size frequency map
 */

import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {

    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) return "";

        // Count frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Max heap based on frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> frequencyMap.get(b) - frequencyMap.get(a)
        );

        maxHeap.addAll(frequencyMap.keySet());

        StringBuilder result = new StringBuilder();
        char prevChar = ' ';
        int prevFreq = 0;

        while (!maxHeap.isEmpty()) {
            char currentChar = maxHeap.poll();
            int currentFreq = frequencyMap.get(currentChar);

            // If previous character's frequency is greater, we can't arrange
            if (prevFreq > 0) {
                // Can only place current if it's different from previous
                if (currentChar == prevChar) {
                    // Try to pick another character
                    if (maxHeap.isEmpty()) {
                        return ""; // No valid arrangement
                    }

                    char nextChar = maxHeap.poll();
                    int nextFreq = frequencyMap.get(nextChar);

                    result.append(nextChar);
                    frequencyMap.put(nextChar, nextFreq - 1);

                    // Put current back to heap and update previous
                    if (nextFreq - 1 > 0) {
                        maxHeap.offer(currentChar);
                    }

                    prevChar = nextChar;
                    prevFreq = nextFreq - 1;
                } else {
                    result.append(currentChar);
                    frequencyMap.put(currentChar, currentFreq - 1);

                    if (currentFreq - 1 > 0) {
                        maxHeap.offer(currentChar);
                    }

                    prevChar = currentChar;
                    prevFreq = currentFreq - 1;
                }
            } else {
                result.append(currentChar);
                frequencyMap.put(currentChar, currentFreq - 1);

                if (currentFreq - 1 > 0) {
                    maxHeap.offer(currentChar);
                }

                prevChar = currentChar;
                prevFreq = currentFreq - 1;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReorganizeString sol = new ReorganizeString();

        System.out.println(sol.reorganizeString("abbaca"));      // "ababac" or "abacab"
        System.out.println(sol.reorganizeString("aabbb"));       // "" (not possible)
        System.out.println(sol.reorganizeString("a"));           // "a"
    }
}
