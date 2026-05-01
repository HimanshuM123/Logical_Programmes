package codingInterview;

import java.util.Arrays;

public class MoveZerosToTheEnd {
	public static void main(String[] args) {
		int[] arr = { 3, 2, 0, 5, 0, 1, 0 };
		int[] result = moveZeros(arr);
		System.out.println(Arrays.toString(result));

	}

	private static int[] moveZeros(int[] arr) {

		int i = 0;
		int j = 0;

		while (j < arr.length) {
			if (arr[j] != 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
			j++;
		}
		return arr;
	}

}
