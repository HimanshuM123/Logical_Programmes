package twoPointer;

import java.util.Arrays;

public class SumPair {
	private static int[] findPair(int[] arr, int sum) {
		int result[] = new int[2];
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int temp_sum = arr[left] + arr[right];
			if (temp_sum > sum) {
				right--;
			} else if (temp_sum < sum) {
				left++;
			} else {
				result[0] = left;
				result[1] = right;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 35, 50, 75, 80 };
		int[] result = findPair(arr, 70);
		System.out.println(Arrays.toString(result));
	}

}


/*
Given a sorted array A (sorted in ascending order), having N integers, 
find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X.
A[] = {10, 20, 35, 50, 75, 80}
X = =70
i = 0
j = 5

*/