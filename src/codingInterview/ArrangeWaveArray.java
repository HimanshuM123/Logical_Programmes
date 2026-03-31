package codingInterview;

import java.util.Arrays;

public class ArrangeWaveArray {
	
	/*
	 * Given an array arr, rearrange it so that:

arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] ...

This creates a wave pattern 🌊
	 * 
	 */
	
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6 };

		int n = arr.length;

		for (int i = 0; i < n; i = i + 2) {

			if (i > 0 && arr[i] < arr[i - 1]) {
				int tmp = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = tmp;

			}

			if (i < n && arr[i] < arr[i + 1]) {
				int tmp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = tmp;
			}

		}
		
		System.out.println(Arrays.toString(arr));
		
		//Wave form:

		//2 >= 1 <= 4 >= 3 <= 6 >= 5 ✅
//		 \      /    \    /   \     /
//		  \     /     \   /    \   /
		
	}

}
