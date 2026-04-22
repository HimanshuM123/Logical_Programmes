package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsArray {
	
	public static void main(String[] args) {
		int [] nums = {1,2};
		boolean[] used = new boolean[nums.length]; 
		permute(nums,new ArrayList<>(),used);
	}
	
	
	static void permute(int[] nums, List<Integer> current, boolean[] used) {
	    // base case
	    if (current.size() == nums.length) {
	        System.out.println(current);
	        return;
	    }

	    for (int i = 0; i < nums.length; i++) {
	        if (used[i]) continue;   // skip used numbers

	        // choose
	        used[i] = true;
	        current.add(nums[i]);

	        // explore
	        permute(nums, current, used);

	        // unchoose (BACKTRACK)
	        current.remove(current.size() - 1);
	        used[i] = false;
	    }
	}

}


/*
[1, 2]
[2, 1]

*/