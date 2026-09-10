package maang;

/*
 * 
 * Problem: Find the contiguous subarray with the largest product.
Example:

Input: nums = [2,3,-2,4]
Output: 6


 * 
 */

public class maxProductSubArray {

	public static void main(String[] args) {

		int[] arr = { 2, 3, -2, 4 };
	int result =	maxProduct(arr);
	
	System.out.println(result);

	}

	public static int maxProduct(int[] nums) {

		int maxProd = nums[0];
		int minProd = nums[0];
		int result = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < 0) {
				int tmp = maxProd;
				maxProd = minProd;
				minProd = tmp;
			}

			maxProd = Math.max(nums[i], maxProd * nums[i]);
			minProd = Math.min(nums[i], minProd * nums[i]);
			result = Math.max(result, maxProd);

		}

		return result;
	}
}
