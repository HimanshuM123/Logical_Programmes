package searching;

import java.util.Arrays;

public class FindPair2 {

	public static void main(String[] args) {
		int[] arr = { 4, 6, 8, 9, 1, 2, 3, 5 };
		int sum = 17;
		int[] result = findPair(arr, sum);
		System.out.println("The result is " + Arrays.toString(result));

	}

	// {1,2,3,4,5,6,8,9}

	private static int[] findPair(int[] arr, int sum) {
		int[] result = new int[2];
		Arrays.sort(arr);

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			int tempSum = arr[left] + arr[right];
			if (tempSum < sum) {
				left++;
			} else if (tempSum > sum) {
				right--;
			} else {
				result[0] = arr[left];
				result[1] = arr[right];
				break;
			}
		}
		return result;

	}

}

// complexity => o(n)
