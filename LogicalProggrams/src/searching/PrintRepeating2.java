package searching;

import java.util.Arrays;

public class PrintRepeating2 {
	public static void main(String[] args) {
		int arr[] = { 3, 7, 4, 1, 4, 6, 8, 7, 8 };
		print(arr);
	}

	private static void print(int[] arr) {
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				System.out.println(arr[i]);
			}
		}
	}
}
