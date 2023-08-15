package practice2;

import java.util.Arrays;

public class ZeroOnes {
	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 0, 1, 1, 1, 0, 1 };

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[count] = arr[i];
				count++;
			}
		}
		while (count < arr.length) {
			arr[count++] = 1;
		}

		System.out.println(Arrays.toString(arr));

	}
}
