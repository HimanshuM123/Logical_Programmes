package backtracking;
import java.util.ArrayList;
import java.util.List;
public class Subsets {
	    public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        List<Integer> subset = new ArrayList<>();

	        dfs(0, nums, subset, res);
	        return res;
	    }

	    private void dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> res) {
	        if (i >= nums.length) {
	            res.add(new ArrayList<>(subset));
	            return;
	        }

	        // decision to include nums[i] (left)
	        subset.add(nums[i]);
	        dfs(i + 1, nums, subset, res);

	        // decision NOT to include nums[i] (right)
	        subset.remove(subset.size() - 1);
	        dfs(i + 1, nums, subset, res);
	    }

	    public static void main(String[] args) {
	    	Subsets solution = new Subsets();

	        int[] example1 = {1, 2, 3};
	        System.out.println("Example 1:");
	        System.out.println(solution.subsets(example1)); // Output: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]

	        int[] example2 = {0};
	        System.out.println("Example 2:");
	        System.out.println(solution.subsets(example2)); // Output: [[], [0]]
	    }



}





/*
                        [1,2,3]
                    / 	          \
                   1   	           []
                  /   \         /     \
             [1,2]     [1]     [2]     []
             / \        / \     / \     /\
        [1,2,3] [1,2] [1,3] [1][2,3][2][3] []

*/