package codingInterview;

import java.util.Arrays;

/*
 * Given an array of integers nums, find the next permutation of numbers.

The next permutation of an array is the next lexicographically greater arrangement of its numbers.
 * 
 * 
 * [1, 2, 3] ->[1, 3, 2]
 * [7,8,4,6,5,2,1] -> [7,8,5,1,2,4,6]
 */
public class NextPermutation {
	
	public static void main(String[] args) {
		int [] arr = {7,8,4,6,5,2,1};
	//	int [] arr = {1,2,3};
		int n = arr.length;
		
		// Step 1: Find first decreasing index
		int i=n-2;
		while(i>=0 && arr[i]>=arr[i+1]) {
			i--;
		}
        // Step 2: If found, find element just larger than nums[i]
		if(i>=0) {
			int j=n-1;
			while(arr[j]<=arr[i]) {
				j--;
			}
			
			swap(arr, i,j);
		}
		
		 // Step 3: Reverse the suffix
        reverse(arr, i + 1, n - 1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	private static void swap(int [] arr , int i, int j) {
		int tmp = arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
		
	}
	
	
	private static void  reverse(int [] arr, int left, int right) {
		while(left < right) {
			swap(arr, left, right);
			left++;
			right--;
		}
	}

}




/*

[7,8,4,6,5,2,1]
start from end & check for decreasing order

[7,8,5,6,4,2,1] -> [7,8,5,1,2,4,6]

*/