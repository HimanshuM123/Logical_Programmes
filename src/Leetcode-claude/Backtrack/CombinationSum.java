/*
 * LeetCode 39: Combination Sum
 *
 * Problem: Given an array of distinct integers candidates and a target integer,
 * return a list of all unique combinations where the chosen numbers sum to target.
 * Same number from candidates can be chosen unlimited number of times.
 *
 * Example: Input: candidates = [2,3,6,7], target = 7
 *          Output: [[2,2,3],[7]]
 *
 * Approach: Backtracking with Reuse
 * - Each element can be reused, so don't increment index after choosing
 * - Prune: if current sum > target, stop exploring
 * - When sum == target, add to result
 *
 * Time Complexity: O(N^(T/M)) where N is candidates length, T is target, M is min candidate
 * Space Complexity: O(T/M) - recursion depth
 */

import java.util.List;
import java.util.ArrayList;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, int current,
                          List<Integer> combination, List<List<Integer>> result) {
        // Base case: sum equals target
        if (current == target) {
            result.add(new ArrayList<>(combination));
            return;
        }

        // Prune: sum exceeds target
        if (current > target) {
            return;
        }

        // Iterate from start to end
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);

            // Don't increment i, allow reuse of same element
            backtrack(candidates, target, i, current + candidates[i], combination, result);

            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum sol = new CombinationSum();

        System.out.println(sol.combinationSum(new int[]{2, 3, 6, 7}, 7));
        // [[2,2,3],[7]]

        System.out.println(sol.combinationSum(new int[]{2, 3, 5}, 8));
        // [[2,2,2,2],[2,3,3],[3,5]]

        System.out.println(sol.combinationSum(new int[]{2}, 1));
        // []
    }
}
