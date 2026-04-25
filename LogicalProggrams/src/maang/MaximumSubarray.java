package maang;

public class MaximumSubarray {
	public static void main(String[] args) {
		int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxProfit(arr));
	}
	
	
	private static int maxProfit(int [] arr) {
		int currentSum = arr[0];
		int maxSum= arr[0];
		
		for(int i=1;i<arr.length;i++) {
			currentSum = Math.max(arr[i], currentSum+arr[i]);
			maxSum = Math.max(maxSum, currentSum);
			
		}
		
		return maxSum;
		
		
		
	}

}


/*

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6


*/