package codingInterview;

import java.util.Arrays;

public class PlusOne {
	public static void main(String[] args) {
	//	int[] arr = { 1, 5, 9 }; // 160
		int[] arr = {9,9,9 }; // 1000
		int [] result =plusOne(arr);
		System.out.println(Arrays.toString(result));

	}

	private static int[] plusOne(int[] arr) {

		for (int i = arr.length - 1; i > 0; i--) {

			if (arr[i] < 9) {
				arr[i] = arr[i] + 1;
				return arr;

			} else {
				arr[i] = 0;

			}

		}
		
		int [] newArr=new int[arr.length+1];
		newArr[0]=1;
		return newArr;

	}

}

/*
Time complexity O(N)
Space complexity O(1)


*/