package maang;

import java.util.Arrays;

public class SortColors {

	/*
	 * Difficulty: Medium | Companies: Meta, Amazon Problem: Sort array containing
	 * only 0s, 1s, 2s in-place. Example: Input: nums = [2,0,2,1,1,0] 
	 * Output:
	 * [0,0,1,1,2,2]
	 * 
	 */

	public static void main(String[] args) {
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		sortColors(nums);
		System.out.println(Arrays.toString(nums));

	}

	public static void sortColors(int[] nums) {
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;

		while (mid <= high) {
			if (nums[mid] == 0) {
				swap(nums, low++, mid++);
			} else if (nums[mid] == 1) {
				mid++;
			} else {
				swap(nums, mid, high--);
			}
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}

//Time: O(n) | Space: O(1)

