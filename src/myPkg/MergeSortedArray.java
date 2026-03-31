package myPkg;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		int[] A = { 1, 3, 5, 7, 9 };
		int[] B = { 2, 4, 6, 8 };
		// result = [1,2,3,4,5,6,7,8,9]
		int result[] = new int[A.length + B.length];

		int m = A.length;
		int n = B.length;
		int k = m + n;

		while (m > 0 && n > 0) {

			if (A[m - 1] > B[n - 1]) {
				result[k - 1] = A[m - 1];
				m--;
				k--;
			} else if (A[m - 1] < B[n - 1]) {
				result[k - 1] = B[n - 1];
				n--;
				k--;

			}
		}

		while (m > 0) {
			result[k - 1] = A[m - 1];
			m--;
			k--;
		}
		while (n > 0) {
			result[k - 1] = B[n - 1];
			n--;
			k--;
		}
		System.out.println(Arrays.toString(result));
	}
}
