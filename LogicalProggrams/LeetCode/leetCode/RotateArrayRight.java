package leetCode;

import java.util.Arrays;

public class RotateArrayRight {
	public static void main(String[] args) {
		RotateArrayRight r = new RotateArrayRight();
		int [] nums = {-1,-100,3,99};
		r.rotate(nums, 2);
	}

	 public void rotate(int[] nums, int k) {
		 while(k>0) {
		 int temp = nums[nums.length-1];
	        for(int i=nums.length-1;i>0;i--) {
	        	nums[i]=nums[i-1];
	        }
	        nums[0]=temp;
	        k--;
	    }
		 System.out.println(Arrays.toString(nums));
	 }
	}
//https://leetcode.com/problems/rotate-array/description/
//
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]