package codingInterview;

import java.util.Arrays;

//print the array which sum is 0
public class ThreeSum {
	public static void main(String[] args) {

		int[] arr = { -1, 0, 1, 2, -1, -4, 8 };

		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			int left = i + 1;
			int right = arr.length - 1;
			while (left < right) {
				if (arr[i] + arr[left] + arr[right] > 0) {
					right--;
				} else if (arr[i] + arr[left] + arr[right] < 0) {
					left++;
				} else {
					System.out.println("[" + " " + arr[i] + " ," + arr[left] + " ," + arr[right] + "]");
					break;
				}
			}

		}

	}
}
