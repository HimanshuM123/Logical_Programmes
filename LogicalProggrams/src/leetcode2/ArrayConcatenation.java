package leetcode2;

import java.util.Arrays;

public class ArrayConcatenation {
	public static void main(String[] args) {
		int [] nums = {1,2,1};
		int[] result = getConcatenation(nums);
		System.out.println(Arrays.toString(result));
		
	}
	
	private static  int[] getConcatenation(int[] nums) {
        int arrLength = 2 * nums.length;
        int [] result = new int[arrLength];
        int j =0;
        int i=0;
            while(j< arrLength){
            result[j] = nums[i];
            j++;
            i++;
            if(i == nums.length){
                i=0;
                System.out.println("test"+i);
            }
            
            }
     
        return result;
        
    }

}
