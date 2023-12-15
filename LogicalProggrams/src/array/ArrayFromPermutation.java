package array;

import java.util.Arrays;

public class ArrayFromPermutation {
	public static void main(String[] args) {
		int [] arr = {0,2,1,5,3,4};
		int [] res = buildArray2(arr);
		System.out.println(Arrays.toString(res));
	}
	
	 public static int[] buildArray(int[] nums) {
	        int len = nums.length;
	        int [] result = new int[len];
	        for(int i=0 ;i < len ; i++){
	            result[i]=nums[nums[i]];
	        }
	        return result;
	    }
	 
	 public static int[] buildArray2(int[] nums) {
		 int len = nums.length;
		 for(int i=0; i< len; i++) {
			 nums[i]= len * (nums[nums[i]]% len)+ nums[i];
		 }
		 for(int i=0; i< len; i++) {
			 nums[i]= nums[i] / len;
		 }
		 return nums;
	    }
	 

}

/*
Input: nums = [0,2,1,5,3,4]
Output: [0,1,2,4,5,3]
Explanation: The array ans is built as follows: 
ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
    = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
    = [0,1,2,4,5,3]
    
    output -> [0, 1, 2, 4, 5, 3]

*/