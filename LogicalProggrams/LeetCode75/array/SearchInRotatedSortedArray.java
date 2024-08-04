package array;

public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

		int target = 0;
		
		System.out.println(search(nums, target));

	}

	private static int search(int[] arr, int target) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (target == arr[mid]) {
				return mid;
			}
			// left sorted portion
			if (arr[left] <= arr[mid]) {
				if (target > arr[mid] || target < arr[left]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}

			}

			// right sorted portion
			else {
				if (target < arr[mid] || target > arr[right]) {

					right = mid - 1;
				} else {
					left = mid + 1;
				}

			}

		}

		return -1;
	}
}

/*
Complexity = O Log(N)


Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 
 
 


*/