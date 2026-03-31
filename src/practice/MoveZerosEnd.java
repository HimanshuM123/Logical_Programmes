package practice;

import java.util.Arrays;

public class MoveZerosEnd {

	public static void main(String[] args) {
		int[] arr = { 3, 0, 5, 0, 0, 1, 2 };
		int[] result = moveZeros(arr);
		System.out.print(Arrays.toString(result));

	}

	private static int[] moveZeros(int[] arr) {
		int left = 0;
		int right = 0;

		while (right < arr.length) {
			if (arr[right] != 0) {
				int z = arr[left];
				arr[left] = arr[right];
				arr[right] = z;
				left++;
			}
			right++;
		}

		return arr;
	}

}
