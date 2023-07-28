package leetCode;

import java.util.Arrays;

/*
 Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 * */
public class RemoveDuplicates {
	public static void main(String[] args) {
		int [] arr = {6,6,1,1,1,1,2,2,3,3,4};
//		int [] arr = {1,1,3,4};
		RemoveDuplicates r = new RemoveDuplicates();
		System.out.println("Result :"+r.removeDuplicates(arr));
	}

	public int removeDuplicates(int[] nums) {
		int j=0;
		for(int i=0;i<=nums.length-1;i++) {
			while(i<nums.length-1 && nums[i+1]==nums[i] ) {
				i++;
			}
			nums[j]=nums[i];
			j++;	
		}
		nums = Arrays.copyOf(nums, j);
		return j;
	}
}
