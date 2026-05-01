package leetcode2;

import java.util.Arrays;

public class SortedSquares {
	public static void main(String[] args) {

		int a[] = {-4 , -1 ,0 , 3, 10};
		int res[] = sortedSquares(a);
		System.out.println(Arrays.toString(res));
	}

	private static int[] sortedSquares(int[] a) {

		int length = a.length;
		int pos_ptr = 0;

		while (pos_ptr < length && a[pos_ptr] < 0) {
			pos_ptr++;
		}

		int neg_ptr = pos_ptr - 1;
		int[] sortedSquares = new int[length];
		int counter = 0;

		while (neg_ptr >= 0 && pos_ptr < length) {
			if (a[neg_ptr] * a[neg_ptr] < a[pos_ptr] * a[pos_ptr]) {
				sortedSquares[counter] = a[neg_ptr] * a[neg_ptr];
				neg_ptr--;
			} else {
				sortedSquares[counter] = a[pos_ptr] * a[pos_ptr];
				pos_ptr++;
			}
			counter++;
		}

		while (neg_ptr >= 0) {
			sortedSquares[counter] = a[neg_ptr] * a[neg_ptr];
			neg_ptr--;
			counter++;
		}
		while (pos_ptr < length) {
			sortedSquares[counter] = a[pos_ptr] * a[pos_ptr];
			pos_ptr++;
			counter++;
		}
		return sortedSquares;
	}
}

// [-4 , -1 ,0 , 3, 10]  -> [0,1,9,16,100]