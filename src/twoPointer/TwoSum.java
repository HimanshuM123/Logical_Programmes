package twoPointer;

import java.util.Arrays;

public class TwoSum {
	public static void main(String[] args) {
		int []nums = {2,7,11,15}; int target = 9;
		int [] result = twoSum(nums, target);
		
		System.out.println(Arrays.toString(result));
		
	}
	
	
	private static int [] twoSum(int [] arr , int target) {
		
		int left =0;
		int right = arr.length-1;
		Arrays.sort(arr);
		int res[] = {0,0};
		while(left < right) {
			
			int sum = arr[left]+arr[right];
			if(sum <target) {
				left++;
			}else if(sum >target) {
				right--;
			}else {
				res[0] = left;
				res[1]=right;
				return res;
			}
		}
		return res;
		
		
	}

}


/*

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*/