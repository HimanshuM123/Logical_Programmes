package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsArray {
	
	public static void main(String[] args) {
		int [] nums = {1,2};
		permute(nums,new ArrayList<>());
	}
	
	
	static void permute(int[] nums, List<Integer> current) {
		// base case
		if (current.size() == nums.length) {
			System.out.println(current);
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			current.add(nums[i]);
			permute(nums, current);
			current.remove(current.size() - 1);
		}

	}

}


/*
[1, 1]
[1, 2]
[2, 1]
[2, 2]

*/