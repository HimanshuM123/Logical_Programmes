/*
 * LeetCode 31: Next Permutation
 *
 * Problem: Implement next permutation, which rearranges numbers into the lexicographically
 * next greater permutation. If such arrangement is not possible, return the smallest arrangement
 * (sorted in ascending order).
 *
 * Example: [1,3,2] -> [2,1,3]
 *          [3,2,1] -> [1,2,3]
 *
 * Approach: Three Steps
 * 1. Find the largest index i such that a[i] < a[i+1]
 * 2. If no such index exists, reverse entire array
 * 3. Find largest j > i such that a[i] < a[j]
 * 4. Swap a[i] and a[j]
 * 5. Reverse subarray from i+1 to end
 *
 * Time Complexity: O(n) - one pass
 * Space Complexity: O(1) - only swap operations
 */

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;

        // Step 1: Find the largest index i such that nums[i] < nums[i+1]
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // If no such index exists, reverse entire array
        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Step 2: Find largest j > i such that nums[i] < nums[j]
        int j = nums.length - 1;
        while (j > i && nums[j] <= nums[i]) {
            j--;
        }

        // Step 3: Swap nums[i] and nums[j]
        swap(nums, i, j);

        // Step 4: Reverse subarray from i+1 to end
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation sol = new NextPermutation();

        int[] arr1 = {1, 3, 2};
        sol.nextPermutation(arr1);
        System.out.println(java.util.Arrays.toString(arr1)); // [2,1,3]

        int[] arr2 = {3, 2, 1};
        sol.nextPermutation(arr2);
        System.out.println(java.util.Arrays.toString(arr2)); // [1,2,3]

        int[] arr3 = {1, 1, 5};
        sol.nextPermutation(arr3);
        System.out.println(java.util.Arrays.toString(arr3)); // [1,5,1]
    }
}
