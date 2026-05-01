package array;

import java.util.Arrays;

public class EvenOddArray2 {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {
			if (arr[left] % 2 > arr[right] % 2) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			} else if (arr[left] % 2 == 0) {
				left++;
			} else if (arr[right] % 2 == 1) {
				right--;
			}

		}

		System.out.println(Arrays.toString(arr));
	}
}

//[1,2,3,4,5,6,7,8,9]=> [8, 2, 6, 4, 5, 3, 7, 1, 9]
