package codingInterview;

import java.util.Arrays;

//Merge sorted array without using space
public class MergeSortedArray {
	
	public static void main(String[] args) {
		int[] a = { 3, 5, 7, 0, 0, 0, 0 };
		int[] b = { 1, 2, 6, 8 };

		int m = 3;
		int n = 4;

		int idx = m+n - 1;
		int i = m - 1;
		int j = n - 1;

		while (i >= 0 && j >= 0) {
			if (a[i] > b[j]) {
				a[idx] = a[i];
				i--;
			} else {
				a[idx] = b[j];
				j--;
			}
			idx--;

		}

		while (j >= 0) {

			a[idx] = b[j];
			j--;

			idx--;

		}
		
		System.out.println(Arrays.toString(a));

	}

}
