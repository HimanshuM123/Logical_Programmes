package twoPointer;

import java.util.Arrays;

public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4, 2, 2, 3, 3, 4 };

		Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));

		int left = 0;
		int right = 1;

		while (right < arr.length) {
			if (arr[left] != arr[right]) {
				left++;
				arr[left] = arr[right];
			

			}
			right++;

		}
		System.out.println(Arrays.toString(arr));
		System.out.println(left);
		
	}

}

/*

[0, 1, 2, 3, 4, 3, 3, 3, 4, 4]
4


*/