package codingInterview;

import java.util.Arrays;

public class RangeSumQueries {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 8, 3 };
		int result = sum(arr, 2, 4); // 15 = 4+8+3
		System.out.println(result);

	}

	private static int sum(int[] arr, int x, int y) {

		int n = arr.length;
		int[] sumArr = new int[n];

		sumArr[0] = arr[0];
		for (int i = 1; i < n; i++) {
			sumArr[i] = sumArr[i - 1] + arr[i];
		}

		// System.out.println(Arrays.toString(sumArr));

		if (x == 0) {
			return sumArr[0];
		} else {
			return sumArr[y] - sumArr[x - 1];
		}

	}

}

/*
 * 
 * sum array =[1,3,7,15,18]
 * 
 * Time Complexity = O(Q)
 * Space complexity =O(n)
 * 
 * 
 * 
 */