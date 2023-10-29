package myPkg;

import java.util.Arrays;

public class LongestConsecutiveSequence2 {
	public static void main(String[] args) {

		int arr[] = { 102, 103, 104, 105, 3, 4, 2, 100, 101, 1 };
		Arrays.sort(arr);
		int count = 1;
		int result = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] + 1 == arr[i]) {
				count++;
			} else {
				if (count > result) {
					result = count;
					count = 1;
				}
			}
		}
		if (count > result) {
			result = count;
		}
		System.out.println(result);

		// 1,2,3,4,100,101,102,103,104,105

	}
}

// [3,4,2,100,101,1] == 1,2,3 => 3
