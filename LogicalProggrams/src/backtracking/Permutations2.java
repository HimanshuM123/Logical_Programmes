package backtracking;


import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();

        backtrack(nums, solution, perms);
        return perms;
    }

    private void backtrack(int[] nums, List<Integer> solution, List<List<Integer>> perms) {
        if (solution.size() == nums.length) {
            perms.add(new ArrayList<>(solution));
            return;
        }

        for (int num : nums) {
            if (!solution.contains(num)) {
                solution.add(num);
                backtrack(nums, solution, perms);
                solution.remove(solution.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
    	Permutations2 solution = new Permutations2();

        int[] example1 = {1, 2, 3};
        System.out.println("Example 1:");
        System.out.println(solution.permutations(example1)); // Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

        int[] example2 = {0, 1};
        System.out.println("Example 2:");
        System.out.println(solution.permutations(example2)); // Output: [[0, 1], [1, 0]]
    }
}
