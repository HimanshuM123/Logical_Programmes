package codingInterview;

public class SearchInRotatedSortedArray {
	
	public static void main(String[] args) {
		int  [] arr = {3,4,5,6,7,0,1,2};
		
		int result = search(arr,1);
		System.out.println(result);
		
	}
	
	
	private static int search(int[] arr, int target) {
		
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == target) {
				return mid;
			} else {
				if (arr[mid] >= arr[0]) {
					if (target >= arr[left] && target <= arr[mid]) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}

				} else {

					if (target > arr[mid] && target <= arr[right]) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}

			}

		}

		return -1;
	}

}
