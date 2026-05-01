package twoPointer;

import java.util.Arrays;

public class MoveZeros {

	public static void main(String[] args) {
		int[] arr = { 1, 6, 2, 0, 4, 0, 0, 1 };

		int left = 0;
		int right = 0;

		while (right < arr.length) {
			if (arr[right] != 0) {
				int temp;
				temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				right++;
				left++;
			} else {
				right++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}

/*
 * {1,6,2,0,4,0,0,1} => {1,6,2,4,1,0,0,0}
 * 
 * 
 * 
 * 
 */
