package leetCode;

import java.util.Arrays;
public class RotateArray2 {
	public static void main(String[] args) {
		RotateArray2 r = new RotateArray2();
		int [] nums = {-1,-100,3,99};
	//	int [] nums = {1,2,3,4,5,6,7};
		r.rotate(nums, 2);
	}
	
	 public void rotate(int[] nums, int k) {
		if(nums.length==1) {
			 System.out.println(Arrays.toString(nums));
			 return;
		}
		if(nums.length<k) {
			 reverseArr(nums,0,nums.length-1);
			 return;
		}
		 reverseArr(nums,0,nums.length-1);
		 reverseArr(nums,0,k-1);
		 reverseArr(nums,k,nums.length-1);
		 
	 System.out.println(Arrays.toString(nums));
	 }
	 private void  reverseArr(int[] nums,int start,int end) {
		while(start<end) {
			int temp= nums[start];
			nums[start]=nums[end];
			nums[end]=temp;
			start++;
			end--;
		}
	 }
	 
	
	}
//https://leetcode.com/problems/rotate-array/description/
//
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//1,2,3,4,5,6,7
//7,6,5,4,3,2,1 - reverse

//5,6,7,4,3,2,1-reverse first part
//5,6,7,1,2,3,4-reverse second part