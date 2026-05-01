/*
 * LeetCode 53: Maximum Subarray
 *
 * Problem: Given an integer array nums, find the contiguous subarray which has
 * the largest sum and return its sum.
 *
 * Example: Input: nums = [-2,1,-3,4,-1,2,1,-5,4] -> Output: 6 (subarray [4,-1,2,1])
 *
 * Approach: Kadane's Algorithm
 * - Track maximum sum ending at current position
 * - At each element, decide: extend existing subarray or start new one
 * - Keep track of overall maximum sum
 *
 * Time Complexity: O(n) - single pass
 * Space Complexity: O(1) - only a few variables
 */

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxCurrent = nums[0];  // Max sum ending at current position
        int maxGlobal = nums[0];   // Overall maximum sum

        for (int i = 1; i < nums.length; i++) {
            // Either extend existing subarray or start new one with current element
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);

            // Update global maximum
            maxGlobal = Math.max(maxGlobal, maxCurrent);
        }

        return maxGlobal;
    }

    public static void main(String[] args) {
        MaximumSubarray sol = new MaximumSubarray();

        System.out.println(sol.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(sol.maxSubArray(new int[]{5, -3, 5}));                      // 7
        System.out.println(sol.maxSubArray(new int[]{-1}));                            // -1
        System.out.println(sol.maxSubArray(new int[]{-2, -1}));                        // -1
    }
}
