/*
 * LeetCode 77: Combinations
 *
 * Problem: Given two integers n and k, return all combinations of k numbers
 * from the range [1, n].
 *
 * Example: Input: n = 4, k = 2
 *          Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 *
 * Approach: Backtracking
 * - At each position, iterate from current number to n
 * - Add number to current combination
 * - When combination size = k, add to result
 * - Backtrack and try other numbers
 *
 * Time Complexity: O(C(n,k) * k) where C(n,k) = n! / (k! * (n-k)!)
 * Space Complexity: O(C(n,k)) for storing results
 */

import java.util.List;
import java.util.ArrayList;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        // Base case: combination complete
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Pruning: not enough numbers left
        if (start > n) {
            return;
        }

        // Iterate from start to n
        for (int i = start; i <= n; i++) {
            current.add(i);

            backtrack(n, k, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations sol = new Combinations();

        System.out.println(sol.combine(4, 2));   // [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        System.out.println(sol.combine(1, 1));   // [[1]]
        System.out.println(sol.combine(5, 3));
    }
}
