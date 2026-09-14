package maang;

/*
 * Q12. Search in Rotated Sorted Array

 * Problem: Search a target in a rotated sorted array. Return index or -1.

Example:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
 */
public class SearchInRotatedArray {

	public static void main(String[] args) {
		
		int [] arr = {4,5,6,7,0,1,2};

		int result =  search( arr,  6);
		System.out.println(result);
		
	}

	public static int search(int[] arr, int target) {

		int left = 0;
		int right = arr.length - 1;
		

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			if(arr[left]<=arr[mid]) {
				if(arr[left]<=target && target <=arr[mid]) {
					right =mid-1;
				}else {
					left =mid+1;
				}
			}else {
				
				if(arr[mid]<target && target <=arr[right]) {
					left = mid+1;
				}else {
					right = mid-1;
				}
			}

		}
		return -1;

	}

}
