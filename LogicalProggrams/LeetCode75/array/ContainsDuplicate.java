package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public static void main(String[] args) {
		int [] arr = {1,2,3,1};
		
		boolean result =containsDuplicate(arr);
		System.out.println(result);
		
	}
	
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (!set.add(nums[i])) {
				return true;
			}
		}

		return false;
	}

}


/*
Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

*/