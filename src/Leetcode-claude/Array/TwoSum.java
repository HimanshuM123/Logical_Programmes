/*
 * LeetCode 1: Two Sum
 *
 * Problem: Given an array of integers nums and an integer target, return the indices
 * of the two numbers that add up to target. Each input has exactly one solution.
 * You may not use the same element twice.
 *
 * Example: Input: nums = [2,7,11,15], target = 9 -> Output: [0,1]
 *
 * Approach: HashMap (Two-pass)
 * - First pass: store each number and its index in HashMap
 * - Second pass: for each number, check if (target - number) exists
 * - Alternative: One-pass by checking as we insert
 *
 * Time Complexity: O(n) - single pass with O(1) HashMap lookup
 * Space Complexity: O(n) - HashMap stores up to n numbers
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement already exists in map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store current number and its index
            map.put(nums[i], i);
        }

        return new int[0]; // No solution found
    }

    public static void main(String[] args) {
        TwoSum sol = new TwoSum();

        System.out.println(Arrays.toString(sol.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(sol.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(sol.twoSum(new int[]{3, 3}, 6)));
    }
}
