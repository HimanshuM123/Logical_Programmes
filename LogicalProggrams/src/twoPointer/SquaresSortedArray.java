package twoPointer;

import java.util.Arrays;

public class SquaresSortedArray {

	public static void main(String[] args) {
		int[] arr = { -7,-3,2,3,11 };

		int[] result = squareSorted(arr);
		System.out.print(Arrays.toString(result));

	}

	static int[] squareSorted(int[] nums) {

		int[] result = new int[nums.length];
		int left = 0;
		int right = nums.length - 1;
		int j = nums.length-1;

		while (left <= right) {

			int square1 = nums[left] * nums[left];
			int square2 = nums[right] * nums[right];

			if (square1 < square2) {
				result[j] = square2;
				right--;
			} else {
				result[j] = square1;
				left++;

			}
			j--;

		}

		return (result);

	}
	
	private static int [] rev(int [] arr) {
		
		int left =0 ; int right =arr.length-1;
		while(left<right) {
			
			int a = arr[left];
			arr[left]=arr[right];
			arr[right]=a;
			left++;
			right--;
			
		}
		
		return arr;
		
	}

}
