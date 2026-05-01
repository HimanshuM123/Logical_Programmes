/*
 * LeetCode 46: Permutations
 *
 * Problem: Given an array nums of distinct integers, return all the permutations.
 * You can return the answer in any order.
 *
 * Example: Input: nums = [1,2,3]
 *          Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Approach: Backtracking with Swap
 * - At each level, swap current element with elements ahead
 * - Recursively generate permutations for rest
 * - Backtrack by swapping back
 * - Alternative: Use Set to track used elements
 *
 * Time Complexity: O(n! * n) - n! permutations, each takes O(n) to copy
 * Space Complexity: O(n) - recursion depth
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

    // Approach 1: Backtracking with Swap
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            // Add current permutation
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // Swap
            swap(nums, start, i);

            // Recurse
            backtrack(nums, start + 1, result);

            // Backtrack (swap back)
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Approach 2: Using Set to track used elements
    public List<List<Integer>> permuteSet(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSet(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void backtrackSet(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            current.add(nums[i]);
            used[i] = true;

            backtrackSet(nums, current, used, result);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations sol = new Permutations();

        System.out.println(sol.permute(new int[]{1, 2, 3}));
        System.out.println(sol.permute(new int[]{0, 1}));
        System.out.println(sol.permute(new int[]{1}));
    }
}
