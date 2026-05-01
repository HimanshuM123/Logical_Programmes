package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class Practice {
	
	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
		
	}
	
	private static int maxSum(int [] arr, int n, int k) {
		int maxSum =0;
		
		int windowSum =0;
		for(int i=0; i<k;i++) {
			windowSum = windowSum + arr[i];
		}
		System.out.println("windowSum "+windowSum);
		
		int windowSum1 = windowSum;
		
		for(int i=k ;i <arr.length;i++) {
			maxSum =windowSum1 +arr[i]-arr[i-k];
			
			
			windowSum = Math.max(maxSum, windowSum);
		}
		
		
		return windowSum;
		
		
		
		
	}
	
	
	
	
	

}
