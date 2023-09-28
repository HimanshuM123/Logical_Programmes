package myPkg;

import java.util.Arrays;

public class TwoSumSortedArray {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int target = 7;
		TwoSumSortedArray sum = new TwoSumSortedArray();
		int[] restlt = sum.getIndex(arr, target);
		System.out.println(Arrays.toString(restlt));

	}

	private int[] getIndex(int arr[], int target) {
		int[] result = new int[2];

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum > target) {
				right--;
			} else if (sum < target) {
				left--;
			} else {
				result[0] = left;
				result[1] = right;
				break;
			}
		}

		return result;
	}
}
