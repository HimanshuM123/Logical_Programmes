package codingInterview;

import java.util.Arrays;

public class ValidTriangle {
	
	public static void main(String[] args) {
		int [] nums = {2, 2, 3, 4};
		int result = triangleNumber(nums);
		
		System.out.println(result); //3
		
		/*
		 * 
		 * (2, 3, 4)
			(2, 3, 4)
			(2, 2, 3)
		 * 
		 * 
		 */
		
	}
	
	
	private static int triangleNumber(int[] nums) {
		int count = 0;
		Arrays.sort(nums); //2 2 3 4
		int n = nums.length;

		for (int k = n - 1; k >= 2; k--) {
			int i = 0;
			int j = k - 1;

			while (i < j) {
				if (nums[i] + nums[j] > nums[k]) {
					count = count + (j - i);
					j--;
				} else {
					i++;
				}
			}

		}
		
		
		return count;
		
	}

}


/*

Given an integer array nums, return the number of triplets (i, j, k) such that:

nums[i] + nums[j] > nums[k]
nums[i] + nums[k] > nums[j]
nums[j] + nums[k] > nums[i]

nums = [2, 2, 3, 4]

Valid triangles:

(2, 3, 4)
(2, 3, 4)
(2, 2, 3)

👉 Output: 3

*/