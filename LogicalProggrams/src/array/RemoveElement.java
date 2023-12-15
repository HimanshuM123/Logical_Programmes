package array;

import java.util.Arrays;
//to do
public class RemoveElement {
	public static void main(String[] args) {
		int [] nums = {0,1,2,2,3,0,4,2};
		int result =removeElement(nums,2);
		System.out.println(result);
	}
	/*
	public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        int count =0;
        for(int i=1; i<len;i++){
            if(nums[i-1]==val){
                nums[i-1]=nums[i];
                count++;
            }
            if(i == len-1) {
            	 if(nums[i]==val){
                     count++;
                 }	
            }
        }
        System.out.println(Arrays.toString(nums));
        return count;
    }
	*/
	 public static int removeElement(int[] nums, int val) {
		 int len = nums.length;
	        int count =0;
	        int j=0;
	      int [] result = new int[len];
	      for(int i=0; i< len;i++){
	          if(val != nums[i]){
	             
	                result[j] = nums[i];
	              j++;
	               count++;
	          }
	      }
	      for(int i=0; i< len;i++){
	        
	              nums[i]= result[i] ;
	              
	       
	      }


      return count;
    }
}

/*

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

*/