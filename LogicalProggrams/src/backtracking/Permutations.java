package backtracking;


import java.util.ArrayList;
import java.util.List;

	
	import java.util.ArrayList;
	import java.util.List;

	public class Permutations {
	    public List<List<Integer>> permute(List<Integer> nums) {
	        List<List<Integer>> result = new ArrayList<>();

	        // base case
	        if (nums.size() == 1) {
	            List<Integer> singleElementList = new ArrayList<>(nums);
	            result.add(singleElementList);
	            return result;
	        }

	        for (int i = 0; i < nums.size(); i++) {
	            int n = nums.remove(0);
	            List<List<Integer>> perms = permute(nums);

	            for (List<Integer> perm : perms) {
	                perm.add(n);
	            }
	            result.addAll(perms);
	            nums.add(n);
	        }

	        return result;
	    }

	    public static void main(String[] args) {
	    	Permutations permutations = new Permutations();
	        List<Integer> nums = new ArrayList<>();
	        nums.add(1);
	        nums.add(2);
	        nums.add(3);
	        List<List<Integer>> result = permutations.permute(nums);
	        for (List<Integer> perm : result) {
	            System.out.println(perm);
	        }
	    }
	}


/*
Example 1:
[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
Example 2:
[[0, 1], [1, 0]]
Example 3:
[[1]]


*/