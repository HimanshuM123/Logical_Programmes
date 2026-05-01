/*
 * LeetCode 347: Top K Frequent Elements
 *
 * Problem: Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 * Example: Input: nums = [1,1,1,2,2,3], k = 2 -> Output: [1,2]
 *
 * Approach: HashMap + Min Heap
 * - Count frequency of each element using HashMap
 * - Use min heap of size k to keep track of k most frequent
 * - For each frequency, if heap size > k, remove minimum
 *
 * Time Complexity: O(n + m log k) where m is unique elements
 * Space Complexity: O(m) for HashMap + O(k) for heap
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Arrays;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        // Count frequencies
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Min heap based on frequency (keeps k most frequent)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> frequencyMap.get(a) - frequencyMap.get(b)
        );

        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num);

            // Keep only k elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Build result
        int[] result = new int[k];
        int i = k - 1;
        while (!minHeap.isEmpty()) {
            result[i--] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements sol = new TopKFrequentElements();

        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        // [1, 2]

        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{1}, 1)));
        // [1]

        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{4, 1, 1, 1, 2, 2, 3}, 2)));
        // [1, 2]
    }
}
