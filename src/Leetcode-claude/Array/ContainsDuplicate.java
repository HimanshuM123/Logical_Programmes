/*
 * LeetCode 217: Contains Duplicate
 *
 * Problem: Given an integer array nums, return true if any value appears at least twice,
 * and return false if all elements are distinct.
 *
 * Example: Input: nums = [1,2,3,1] -> Output: true
 *
 * Approach: HashSet
 * - Iterate through array and add elements to HashSet
 * - If element already in set, return true
 * - If loop completes, return false
 *
 * Time Complexity: O(n) - single pass with O(1) HashSet operations
 * Space Complexity: O(min(n, m)) where m is number of unique elements
 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return false;

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    // Alternative: Sort and compare adjacent elements
    // Time: O(n log n), Space: O(1) if not counting sort space
    public boolean containsDuplicateSort(int[] nums) {
        java.util.Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate sol = new ContainsDuplicate();

        System.out.println(sol.containsDuplicate(new int[]{1, 2, 3, 1}));      // true
        System.out.println(sol.containsDuplicate(new int[]{1, 2, 3, 4}));      // false
        System.out.println(sol.containsDuplicate(new int[]{99, 99}));          // true
        System.out.println(sol.containsDuplicate(new int[]{}));                // false
    }
}
