package backtracking;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(candidates, target, 0, cur, res, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> cur, List<List<Integer>> res, int total) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (index >= candidates.length || total > target) {
            return;
        }

        cur.add(candidates[index]);
        dfs(candidates, target, index, cur, res, total + candidates[index]);
        cur.remove(cur.size() - 1);
        dfs(candidates, target, index + 1, cur, res, total);
    }

    public static void main(String[] args) {
    	CombinationSum solution = new CombinationSum();

        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Example 1:");
        System.out.println(solution.combinationSum(candidates1, target1)); // Output: [[2, 2, 3], [7]]

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Example 2:");
        System.out.println(solution.combinationSum(candidates2, target2)); // Output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println("Example 3:");
        System.out.println(solution.combinationSum(candidates3, target3)); // Output: []
    }
}



/*
Example 1:
{2, 3, 6, 7};
[[2, 2, 3], [7]]
Example 2:
{2, 3, 5};
[[2, 2, 2, 2], [2, 3, 3], [3, 5]]
Example 3:
[]

*/

