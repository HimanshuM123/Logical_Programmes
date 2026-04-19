package codingInterview;

import java.util.Arrays;

//RotateArray by K times
public class RotateArray {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 }; // 5,6,7,1,2,3,4

		int k = 3;

		int j = arr.length - 1;

		reverse(arr, 0, j);
		reverse(arr, 0, k - 1);
		reverse(arr, k, j);

		System.out.println(Arrays.toString(arr));

	}

	private static void reverse(int[] arr, int left, int right) {

		while (left < right) {
			int tmp = arr[left];

			arr[left] = arr[right];
			arr[right] = tmp;
			left++;
			right--;

		}

	}

}


/*

1,2,3,4,5,6,7

7,6,5,4,3,2,1

5,6,7,4,3,2,1
5,6,7,1,2,3,4




*/