
package practice2;

import java.util.Arrays;

public class OddEvens {
	public static void main(String[] args) {
		int arr[] = { 12, 17, 70, 15, 22, 65, 21, 90 };

		int count = 0;

		int result[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				result[count] = arr[i];
				count++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				result[count] = arr[i];
				count++;
			}

		}

		System.out.println(Arrays.toString(result));
	}
}
