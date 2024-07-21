package twoPointer;

import java.util.Arrays;

public class TripletSum {
	public static void main(String[] args) {
		int[] arr = { 12, 3, 4, 1, 6, 9 };
		int val = 24;

		Arrays.sort(arr);// 1,3,4,6,9,12

		for (int i = 0; i < arr.length; i++) {
			int x = arr[i];
			int left = i + 1;
			int right = arr.length - 1;

			while (left < right) {
				if (arr[left] + arr[right] + x == val) {
					System.out.println(x + " " + arr[left] + " " + arr[right]);
					right--;
					left++;
				} else if (arr[left] + arr[right] + x < val) {
					left++;
				} else {
					right--;
				}
			}
		}
	}
}


/*

Input: array = {12, 3, 4, 1, 6, 9}, sum = 24; 
Output: 12, 3, 9

*/