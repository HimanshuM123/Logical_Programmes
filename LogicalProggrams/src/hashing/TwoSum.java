package hashing;

import java.util.Arrays;

public class TwoSum {

	private static boolean checkSumPair(int[] arr, int num) {

		int left = 0;
		int right = arr.length-1;
		Arrays.sort(arr);

		while (left <= right) {
			int sum = arr[left] + arr[right];
			if (sum < num) {
				left++;
			}
			if (sum > num) {
				right--;
			} else {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		int arr[] = { 2, 6, 3, 1, 4, 5 };// 9
		boolean result = checkSumPair(arr, 9);

		System.out.println(result);

	}

}

/*
Check if pair with given Sum exists in Array (Two Sum)

Input: arr[] = {0, -1, 2, -3, 1}, x= -2
Output: Yes
Explanation:  If we calculate the sum of the output,1 + (-3) = -2

*/