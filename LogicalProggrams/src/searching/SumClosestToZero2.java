package searching;

import java.util.Arrays;

public class SumClosestToZero2 {
	public static void main(String[] args) {
		int[] arr = { -4, 6, 8, 3, 1, -7, 9 };
		int[] result = sum(arr);
		System.out.println("The result is " + Arrays.toString(result));
	}

	// [-7, -4, 1, 3, 6, 8, 9]
	private static int[] sum(int[] arr) {
		int[] resultArr = new int[2];
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		int left = 0;
		int right = arr.length - 1;
		int minSum = Math.abs(arr[0] + arr[1]);
		while (left < right) {

			int sum = Math.abs(arr[left] + arr[right]);
			if (sum <= minSum) {
				minSum = sum;
				resultArr[0] = arr[left];
				resultArr[1] = arr[right];
			}

			if (sum > 0) {
				right--;
			} else if (sum < 0) {
				left++;
			} else {
				return resultArr;
			}

		}

		return resultArr;
	}
}
