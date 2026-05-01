/*
 * LeetCode 238: Product of Array Except Self
 *
 * Problem: Given an integer array nums, return an array answer where answer[i]
 * is the product of all elements except nums[i].
 * Constraint: You must write an algorithm that runs in O(n) time and
 * without using division operation.
 *
 * Example: Input: nums = [1,2,3,4] -> Output: [24,12,8,6]
 *
 * Approach: Left-Right Product
 * - First pass (left to right): answer[i] = product of all elements to the left
 * - Second pass (right to left): multiply by product of all elements to the right
 *
 * Time Complexity: O(n) - two passes
 * Space Complexity: O(1) - answer array not counted as extra space
 */

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] answer = new int[n];

        // First pass: fill answer with left products
        // answer[i] = product of all elements to the left of i
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Second pass: multiply by right products
        // right = product of all elements to the right
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf sol = new ProductOfArrayExceptSelf();

        System.out.println(java.util.Arrays.toString(sol.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(java.util.Arrays.toString(sol.productExceptSelf(new int[]{2, 3, 4, 5})));
        System.out.println(java.util.Arrays.toString(sol.productExceptSelf(new int[]{1})));
    }
}
