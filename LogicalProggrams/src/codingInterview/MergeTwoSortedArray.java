package codingInterview;

import java.util.Arrays;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		int[] arr1 = { 2, 4, 6, 8 };
		int[] arr2 = { 1, 3, 5 };

		int i = 0, j = 0, k = 0;

		int[] arr = new int[arr1.length + arr2.length];

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				arr[k] = arr1[i];
				i++;
			} else {
				arr[k] = arr2[j];
				j++;
			}
			
			
			k++;
		}

		while (i < arr1.length) {
			arr[k] = arr1[i];
			i++;
			k++;
		}

		while (j < arr2.length) {
			arr[k] = arr1[j];
			j++;
			k++;
		}
		
		System.out.print(Arrays.toString(arr));//[1, 2, 3, 4, 5, 6, 8]

	}

}
