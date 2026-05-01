/*
 * LeetCode 26: Remove Duplicates from Sorted Array
 *
 * Problem: Given an integer array nums sorted in non-decreasing order, remove the duplicates
 * in-place such that each unique element appears only once.
 * Return the number of unique elements k, and place the first k elements correctly.
 *
 * Example: Input: nums = [1,1,2] -> Output: 2, nums = [1,2,_]
 *
 * Approach: Two Pointers
 * - slow pointer tracks position to place unique elements
 * - fast pointer scans through array
 * - When new unique element found, move it to slow position
 *
 * Time Complexity: O(n) - single pass
 * Space Complexity: O(1) - in-place modification
 */

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int slow = 0; // Position to place next unique element

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1; // Number of unique elements
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray sol = new RemoveDuplicatesFromSortedArray();

        int[] arr1 = {1, 1, 2};
        int len1 = sol.removeDuplicates(arr1);
        System.out.println(len1 + " -> " + java.util.Arrays.toString(java.util.Arrays.copyOf(arr1, len1)));

        int[] arr2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = sol.removeDuplicates(arr2);
        System.out.println(len2 + " -> " + java.util.Arrays.toString(java.util.Arrays.copyOf(arr2, len2)));

        int[] arr3 = {1};
        int len3 = sol.removeDuplicates(arr3);
        System.out.println(len3 + " -> " + java.util.Arrays.toString(java.util.Arrays.copyOf(arr3, len3)));
    }
}
