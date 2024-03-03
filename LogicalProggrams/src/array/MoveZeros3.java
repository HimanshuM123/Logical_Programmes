package array;

import java.util.Arrays;

public class MoveZeros3 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 0, 3, 0, 0, 0, 4, 5 };

		int left = 0;
		int right = 0;

		while (right < arr.length) {
			if (arr[right] != 0) {
				int temp;
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
			}
			right++;
		}
		
		System.out.println(Arrays.toString(arr));

	}

}

//[1,2,0,3,0,0,0,4,5]=>[1,2,3,4,5,0,0,0,0]