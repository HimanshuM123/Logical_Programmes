package array;

import java.util.Arrays;

public class ProductOfArray {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };

		int i, temp = 1;
		int n = nums.length;
		int[] prod = new int[n];

		for (int j = 0; j < n; j++) {
			prod[j] = 1;
		}

		for (i = 0; i < n; i++) {
			prod[i] = temp;
			temp = temp * nums[i];
		}
		 System.out.println(Arrays.toString(prod));//[1, 1, 2, 6]

		temp = 1;

		for (i = n - 1; i >= 0; i--) {
			prod[i] = prod[i] * temp;
			temp = temp * nums[i];
		}

		System.out.println(Arrays.toString(prod));
	}
}


/*
 Product of Array Except Self
 Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

*/