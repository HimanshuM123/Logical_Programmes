package array;

public class MaxSubArrayKadane {
	
	/*
	 * 
	 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
		Output: 6  (subarray [4,-1,2,1])
	 * 
	 */
	
	public static void main(String[] args) {
		
		int [] arr = {-2,1,-3,4,-1,15,1,-5,4};
		
		int result = maxSubArray(arr);
		
		System.out.println(result);
		
	}
	
	
	private static int maxSubArray(int [] arr) {
		
		int maxSum =arr[0]; int currentSum = arr[0];
		
		for(int i=1; i< arr.length ; i++) {
			
			currentSum = Math.max(arr[i], currentSum+arr[i]);
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
		
		
	}

}


//Time: O(n) | Space: O(1)