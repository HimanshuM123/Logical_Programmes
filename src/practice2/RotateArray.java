package practice2;

import java.util.Arrays;

public class RotateArray {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		int n = arr.length;
		int k = 4;

		reverse(arr, 0, k - 1);
		reverse(arr, k, n - 1);
		reverse(arr, 0, n - 1);
		System.out.println(Arrays.toString(arr));

	}

	private static int[] reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = 0;
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return arr;
	}
}

//10, 20, 30, 40, 50, 60, 70 =>  50, 60, 70,10, 20, 30, 40