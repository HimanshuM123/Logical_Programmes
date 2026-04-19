package codingInterview;
//LeetCode #945
import java.util.Arrays;

public class MinimumIncrementForUnique {
	
	public static void main(String[] args) {
		 int[] nums = {3, 2, 1, 2, 1, 7};
	        System.out.println(minIncrementForUnique(nums)); // Output: 6
	}
	
	private static int minIncrementForUnique(int [] nums) {
		Arrays.sort(nums);
		//1,1,2,2,3,7
		int moves=0;
		int prev= nums[0];
		
		for(int i=1; i< nums.length;i++) {
			
			if(nums[i]<=prev) {
				  int needed = prev + 1;
	                moves =moves+ needed - nums[i];
	                prev = needed;
	            } else {
	                prev = nums[i];
	            }
	        }

	        return moves;
		
		
		
	}
	

}


/*
[1, 1, 2, 2, 3, 7]

| i | num | prev | action | moves |
| - | --- | ---- | ------ | ----- |
| 0 | 1   | 1    | ok     | 0     |
| 1 | 1   | 1    | → 2    | +1    |
| 2 | 2   | 2    | → 3    | +1    |
| 3 | 2   | 3    | → 4    | +2    |
| 4 | 3   | 4    | → 5    | +2    |
| 5 | 7   | 5    | ok     | 0     |




*/