package leetCode;

import java.util.Arrays;

public class MoveZeros {
	public static void main(String[] args) {
		MoveZeros m = new MoveZeros();
//		int [] nums = {0,1,0,3,12};
		int [] nums = {0,1,0,3,12};
		m.moveZeroes(nums);
	}
	  public void moveZeroes(int[] nums) {
	        int [] result= new int[nums.length];
	        int index =0;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]!=0){
	                result [index]=nums[i];
	                index++;
	            }
	        }
	         for(int i=0;i<nums.length;i++){
	            if(nums[i]==0){
	                result [index]=nums[i];
	                index++;
	            }
	        }
	        
	        System.out.println(Arrays.toString(result).replaceAll("\\s", ""));
	    }
}
