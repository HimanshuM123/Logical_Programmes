package twoPointer;

public class ClosestPair {
	
	public static void main(String[] args) {
		
		 int arr1[] = {1, 4, 5, 7};
	        int arr2[] = {10, 20, 30, 40};
	        int x = 38;
	        printClosest(arr1,arr2,x);
		
	}
	
	private static void printClosest(int arr1[], int arr2[],int x) {
		int diff = Integer.MAX_VALUE;
		int left=0;
		int right = arr2.length-1;
		int left_result=0;
		int right_result=0;
		
		while(right >=0 && left < arr2.length-1) {
			int abs_diff=Math.abs(arr1[left]+arr2[right]-x);
			if(abs_diff<diff) {
				left_result=left;
				right_result=right;
				diff=abs_diff;
			}
			
			if(arr1[left]+arr2[right] > x) {
				right--;
			}else {
				left++;
			}
		}
		
		System.out.println(left_result+"   "+right_result);
		
		
	}

}


/*
Find the closest pair from two sorted arrays

Input: arr1[] = {1, 4, 5, 7};
arr2[] = {10, 20, 30, 40};
x = 32
Output: 1 and 30

Input: arr1[] = {1, 4, 5, 7};
arr2[] = {10, 20, 30, 40};
x = 50
Output: 7 and 40
*/