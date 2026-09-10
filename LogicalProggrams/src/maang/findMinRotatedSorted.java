package maang;

public class findMinRotatedSorted {

	/*
	 * Problem: Find the minimum element in a rotated sorted array. Example: Input:
	 * nums = [3,4,5,1,2] Output: 1
	 * 
	 */

	public static void main(String[] args) {

		int[] arr = { 3, 4, 5, 1, 2 };
		
		System.out.println(findMin(arr));

	}

	public static int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return nums[left];

	}

}
