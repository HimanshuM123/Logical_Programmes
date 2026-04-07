package codingInterview;

public class CircularSubArray {
	public static void main(String[] args) {
		int[] arr = { 1, 5, -3, 2, -5, 6 };
		
		int result = maxSubArrayCircular(arr);//12
	//	int result = maxSubArrayKadane(arr); for non-circular  ->6
		System.out.print(result);
		

	}

	private static int maxSubArrayCircular(int[] arr) {

		int currMax = 0;
		int currMin = 0;
		int maxSum = arr[0];
		int minSum = arr[0];
		int totalSum = 0;

		for (int num : arr) {
			currMax = Math.max(currMax, 0) + num;
			maxSum = Math.max(maxSum, currMax);

			currMin = Math.min(currMin, 0) + num;
			minSum = Math.min(minSum, currMin);

			totalSum = totalSum + num;

		}

		if (totalSum == minSum) {
			return maxSum;
		}

		return Math.max(maxSum, totalSum - minSum);

	}
	
	
	 static int maxSubArrayKadane (int[] arr) {
	        int currSum = arr[0];
	        int maxSum = arr[0];

	        for (int i = 1; i < arr.length; i++) {
	            currSum = Math.max(arr[i], currSum + arr[i]);
	            maxSum = Math.max(maxSum, currSum);
	        }

	        return maxSum;
	    }

}
