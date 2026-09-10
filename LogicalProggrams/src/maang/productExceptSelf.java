package maang;

import java.util.Arrays;

public class productExceptSelf {

	public static void main(String[] args) {
		
		int [] nums= {1,2,3,4};
		
		int res[] = productExceptSelf(nums);
		
		System.out.println(Arrays.toString(res));
		
	}
	
	private static  int[] productExceptSelf(int[] nums) {
		
		int n = nums.length;
		int [] result = new int[n];
		
		result[0]=1;
		
		for(int i=1; i<n; i++) {
			result[i]=result[i-1] *  nums[i-1];
		}
		
		int right =1;
		
		for(int i=n-1; i>=0; i--) {
			result[i]= result[i] * right;
			right = right * nums[i];
		}
		
		return result;
		
	}
	
	
}





/*
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
*/