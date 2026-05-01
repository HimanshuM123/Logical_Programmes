/*
 * LeetCode 78: Subsets
 *
 * Problem: Given an integer array nums of unique elements, return all possible subsets
 * (the power set). The solution set must not contain duplicate subsets.
 *
 * Example: Input: nums = [1,2,3]
 *          Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Approach: Backtracking
 * - Add current combination to result at each step
 * - For each number, decide to include or exclude it
 * - Explore both branches recursively
 *
 * Alternative: Iterative - add each element to all existing subsets
 * Time: O(n * 2^n) - 2^n subsets, each takes O(n) to copy
 * Space: O(n) - recursion depth
 */

import java.util.List;
import java.util.ArrayList;

public class Subsets {

    // Approach 1: Recursive Backtracking
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));

        // Iterate from start to n
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);

            backtrack(nums, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }

    // Approach 2: Iterative
    public List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // Add empty subset

        for (int num : nums) {
            // Add current number to all existing subsets
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Subsets sol = new Subsets();

        System.out.println(sol.subsets(new int[]{1, 2, 3}));
        // [[], [1], [1,2], [1,2,3], [1,3], [2], [2,3], [3]]

        System.out.println(sol.subsets(new int[]{0}));
        // [[], [0]]
    }
}
