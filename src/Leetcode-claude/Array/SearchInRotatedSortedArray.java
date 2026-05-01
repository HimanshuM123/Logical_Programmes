/*
 * LeetCode 33: Search in Rotated Sorted Array
 *
 * Problem: There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index.
 * Given the rotated array and an integer target, return the index of target if found, else -1.
 *
 * Example: Input: nums = [4,5,6,7,0,1,2], target = 0 -> Output: 4
 *
 * Approach: Binary Search with Rotation Detection
 * - Identify which half is sorted
 * - Check if target is in sorted half
 * - Search accordingly
 *
 * Time Complexity: O(log n) - binary search
 * Space Complexity: O(1) - only pointers
 */

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Determine which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                // Check if target is in sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;  // Search left
                } else {
                    left = mid + 1;   // Search right
                }
            } else {
                // Right half is sorted
                // Check if target is in sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;   // Search right
                } else {
                    right = mid - 1;  // Search left
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();

        System.out.println(sol.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));   // 4
        System.out.println(sol.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));   // -1
        System.out.println(sol.search(new int[]{1}, 1));                     // 0
        System.out.println(sol.search(new int[]{3, 1}, 3));                  // 0
    }
}
