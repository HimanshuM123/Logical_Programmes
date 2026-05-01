/*
 * LeetCode 15: 3Sum
 *
 * Problem: Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j != k != i and nums[i] + nums[j] + nums[k] == 0.
 * The solution set must not contain duplicate triplets.
 *
 * Example: Input: nums = [-1,0,1,2,-1,-4] -> Output: [[-1,-1,2],[-1,0,1]]
 *
 * Approach: Sort + Two Pointers
 * - Sort array first
 * - Fix one element and find two sum for remaining = -element
 * - Use two pointers to find pairs efficiently
 * - Skip duplicates to avoid duplicate triplets
 *
 * Time Complexity: O(n^2) - O(n log n) sort + O(n^2) for nested loops
 * Space Complexity: O(1) - not counting output space
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // If current number is positive, no triplet possible
            if (nums[i] > 0) break;

            // Two pointer approach to find pairs that sum to target
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();

        System.out.println(sol.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(sol.threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(sol.threeSum(new int[]{-2, 0, 1, 1, 2}));
    }
}
