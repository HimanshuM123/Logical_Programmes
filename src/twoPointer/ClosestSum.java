package twoPointer;

public class ClosestSum {

	public static void main(String[] args) {
		int[] arr = { 10, 22, 28, 29, 30, 40 };
		int x = 54;

		closestSum(arr, x);
	}

	private static void closestSum(int[] arr, int x) {

		int left = 0;
		int right = arr.length - 1;
		int diff = Integer.MAX_VALUE;
		int left_res = 0;
		int right_res = 0;

		while (left < right) {
			int abs_diff = Math.abs(arr[left] + arr[right] - x);
			if (abs_diff < diff) {
				left_res = left;
				right_res = right;
				diff = abs_diff;
			}
			if (arr[left] + arr[right] > x) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(arr[left_res] + "  " + arr[right_res]);

	}

}

/*
 * 
 * Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54 Output: 22 and 30
 * 
 */