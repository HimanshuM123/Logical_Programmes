/*
 * LeetCode 88: Merge Sorted Array
 *
 * Problem: You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, which represent the number of valid elements in nums1 and nums2.
 * Merge nums2 into nums1 as one sorted array.
 * Note: You may assume nums1 has enough space (size m + n) to hold additional elements.
 *
 * Example: Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 *          Output: [1,2,2,3,5,6]
 *
 * Approach: Reverse Three Pointers
 * - Start from end of both arrays
 * - Compare and place larger element at end of nums1
 * - Move corresponding pointers
 * - Avoids overwriting elements in nums1
 *
 * Time Complexity: O(m + n) - single pass
 * Space Complexity: O(1) - in-place merge
 */

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;

        int p1 = m - 1;        // Pointer for nums1
        int p2 = n - 1;        // Pointer for nums2
        int p = m + n - 1;     // Pointer for merged position

        // Start from end and work backwards
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If nums2 has remaining elements, copy them
        // (nums1 remaining elements are already in place)
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray sol = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        sol.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(java.util.Arrays.toString(nums1)); // [1,2,2,3,5,6]

        int[] nums2 = {4, 5, 6, 0, 0, 0};
        sol.merge(nums2, 3, new int[]{1, 2, 3}, 3);
        System.out.println(java.util.Arrays.toString(nums2)); // [1,2,3,4,5,6]

        int[] nums3 = {1};
        sol.merge(nums3, 1, new int[]{}, 0);
        System.out.println(java.util.Arrays.toString(nums3)); // [1]
    }
}
