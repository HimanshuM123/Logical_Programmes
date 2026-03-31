package codingInterview;

public class ValidSplits {
	public static void main(String[] args) {
		int[] nums = { 10, 4, -8, 7, 3, 6 };
		
		int result = waysToSplitArray(nums);
		System.out.println(result);

	}

	private static int waysToSplitArray(int[] nums) {
		int count =0;
		int totalSum =0;
		
		for(int obj : nums) {
			totalSum= totalSum +obj;
		}
		
		int leftSum =0;
		int rightSum =0;
		for ( int i =0; i< nums.length-1 ; i++) {
			leftSum = leftSum+ nums[i];
			
			rightSum = totalSum-leftSum;
			
			if(leftSum > rightSum) {
				count++;
			}
		}		
		return count;

	}
}


/*
 
 
 [10, 4 ,-8, 7 ,3 ,6]
 
 return the pair where left sum >= right sum
 
  [10, 4] [-8, 7 ,3 ,6]  ->14 >= 8
  [10, 4 ,-8, 7 ] [3 ,6] -> 13 >= 9 
  [10, 4 ,-8, 7 ,3 ] [6] -> 16 >= 6
 
 
 
 
 
 
 
 
 
 
 
 */
