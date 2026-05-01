package searching;

import java.util.Arrays;

public class SumClosestToZero {
	public static void main(String[] args) {
		int[] arr = { -4, 6, 8, 3, 1, -7, 9 };
		int[] result = sum(arr);
		System.out.println("The result is " + Arrays.toString(result));
	}

	private static int[] sum(int[] arr) {
		int minSum = Math.abs(arr[0] + arr[1]);
		int[] resultArr = new int[2];
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = Math.abs(arr[i] + arr[j]);
				if (sum < minSum) {
					minSum = sum;
					resultArr[0] = arr[i];
					resultArr[1] = arr[j];
				}
			}
		}
		return resultArr;
	}
}
