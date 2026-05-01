/*
 * LeetCode 189: Rotate Array
 *
 * Problem: Given an integer array nums, rotate the array to the right by k steps,
 * where k is non-negative.
 *
 * Example: Input: nums = [1,2,3,4,5,6,7], k = 3 -> Output: [5,6,7,1,2,3,4]
 *
 * Approach: Reverse Algorithm (Space Optimal)
 * 1. Normalize k = k % n (handle k > n)
 * 2. Reverse entire array
 * 3. Reverse first k elements
 * 4. Reverse remaining n-k elements
 *
 * Example: [1,2,3,4,5,6,7], k=3
 * - Reverse all:   [7,6,5,4,3,2,1]
 * - Reverse 0-2:   [5,6,7,4,3,2,1]
 * - Reverse 3-6:   [5,6,7,1,2,3,4]
 *
 * Time Complexity: O(n) - three passes through array
 * Space Complexity: O(1) - in-place rotation, only pointers
 */

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;

        k = k % nums.length; // Handle k > n

        // Step 1: Reverse entire array
        reverse(nums, 0, nums.length - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse remaining elements
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Swap
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray sol = new RotateArray();

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        sol.rotate(arr1, 3);
        System.out.println(java.util.Arrays.toString(arr1)); // [5,6,7,1,2,3,4]

        int[] arr2 = {-1, -100, 3, 99};
        sol.rotate(arr2, 2);
        System.out.println(java.util.Arrays.toString(arr2)); // [3,99,-1,-100]

        int[] arr3 = {1};
        sol.rotate(arr3, 0);
        System.out.println(java.util.Arrays.toString(arr3)); // [1]
    }
}
