package slidingWindow;

public class MaximumSum {

	private static int maxSum(int[] arr, int n, int k) {
		int max_sum = 0;
		for (int i = 0; i < k; i++) {
			max_sum = max_sum + arr[i];
		}
		int window_sum = max_sum;
		for (int i = k; i < n; i++) {
			int temp =arr[i] - arr[i - k];
			window_sum = window_sum +temp;
			max_sum = Math.max(max_sum, window_sum);
		}

		return max_sum;

	}
	
	
	public static void main(String[] args) {

		int arr[] = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
	}
}


/*
Given an array of integers of size ‘n’, 
Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.

Input  : arr[] = {100, 200, 300, 400}, k = 2
Output : 700

Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4 
Output : 39
We get maximum sum by adding subarray {4, 2, 10, 23} of size 4.

Input  : arr[] = {2, 3}, k = 3
Output : Invalid
There is no subarray of size 3 as size of whole array is 2.



*/
