package twoPointer;

import java.util.Arrays;

public class TripletWithZeroSum {
	public static void main(String[] args) {
		int[] arr = { 0, -1, 2, -3, 1 };

		Arrays.sort(arr); // -3, -1,0,1,2

		for (int i = 0; i < arr.length; i++) {
			int x = arr[i];
			int left = i + 1;
			int right = arr.length - 1;
			while (left < right) {
				if (x + arr[left] + arr[right] == 0) {
					System.out.println(x+"  "+arr[left]+"  "+arr[right]);
					System.out.println("----------------------------");
					left++;
					right--;
				} else if (x + arr[left] + arr[right] < 0) {
					left++;

				} else {
					right--;
				}
			}
		}
	}
}




/*

Input: arr[] = {0, -1, 2, -3, 1}
Output: (0 -1 1), (2 -3 1)
Explanation: The triplets with zero sum are 0 + -1 + 1 = 0 and 2 + -3 + 1 = 0  


*/