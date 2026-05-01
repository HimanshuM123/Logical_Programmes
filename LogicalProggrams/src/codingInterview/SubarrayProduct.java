package codingInterview;

public class SubarrayProduct {
	
	public static void main(String[] args) {
		int [] nums = {10, 5, 2, 6};
		 int k = 100;
		int res =numSubarrayProductLessThanK(nums,k);
		System.out.println("The result is "+res);
	}
	
	 public static int numSubarrayProductLessThanK(int[] nums, int k) {
	        if (k <= 1) return 0;
	        
	        int left = 0;
	        int product = 1;
	        int count = 0;
	        
	        for (int right = 0; right < nums.length; right++) {
	            product = product * nums[right];
	            
	            while (product >= k) {
	                product = product/nums[left];
	                left++;
	            }
	            
	            count =count+ (right - left + 1);
	        }
	        
	        return count;
	    }

}

/*
 * 
 * nums = [10, 5, 2, 6], k = 100

Valid subarrays:

[10], [5], [2], [6],
[10,5], [5,2], [2,6],
[5,2,6]
 * */
