package codingInterview;

import java.util.Arrays;

public class ProductExceptSelf {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };

		int[] result = productExceptSelf(arr);

		System.out.println(Arrays.toString(result));// [24, 12, 8, 6]

	}

	private static int[] productExceptSelf(int[] arr) {

		int n = arr.length;
		int[] answer = new int[n];

		// Step 1: Left products
		answer[0] = 1;
		for (int i = 1; i < n; i++) {
			answer[i] = answer[i - 1] * arr[i - 1];

		}

		// Step 2: Right products
		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			answer[i] = answer[i] * right;
			right = right * arr[i];
		}

		return answer;

	}

}
/*

1,  2,   3,   4
1,  1,   2,   6
24  12,  4,   1
24  12   8    6  =ans


*/