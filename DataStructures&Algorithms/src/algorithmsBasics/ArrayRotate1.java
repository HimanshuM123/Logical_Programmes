package algorithmsBasics;

import java.util.Arrays;

public class ArrayRotate1 {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		rotateArray(arr,arr.length,4);
		System.out.println(Arrays.toString(arr));
	}

	public static void rotateArray(int[] a, int n, int k) {
		reverseArray(a, 0, k - 1);
		reverseArray(a, k, n - 1);
		reverseArray(a, 0, n - 1);
	}

	public static void reverseArray(int[] a, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
}
