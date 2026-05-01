package twoPointer;

import java.util.Arrays;

public class RemoveDuplicates2 {
	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };

		int left = 0;
		int right = 1;
		int counter = 0;

		while (right < arr.length) {
			if (arr[left] != arr[right] ) {
				left++;
				arr[left] = arr[right];
				counter=0;
			}else if (arr[left] == arr[right] && counter <1) {
				counter++;
				arr[++left] = arr[right];
			}

			right++;
		}
		
		System.out.println(Arrays.toString(arr));

	}

}


/*
Remove duplicates where it apprears at-most twice

0,0,1,1,1,1,2,3,3

=>0,0,1,1,2,3,3


*/