package algorithmRecursion;

public class BinaryMaxRecur {

	// Driver code
	public static void main(String[] args) {
		//int arr[] = { 5, 6,7, 1, 2, 3, 4 };
		//int arr[] = {  1, 2, 3, 4,5, 6,7 };
		int arr[] = {  6,7,1,2,3,4,5 };
		
		System.out.println(findMax(arr, 0, arr.length - 1));
	}

	// Function to return the maximum element
	static int findMax(int arr[], int low, int high) {

		// This condition is for the case when
		// array is not rotated at all
		//{0,1,2,3,4,5}
		//if (high < low)
			//return arr[0];

		// If there is only one element left
		if (high == low)
			return arr[low];

		// Find mid
		int mid = low + (high - low) / 2;

		// Check if mid itself is maximum element
		if (mid < high && arr[mid + 1] < arr[mid]) {
			return arr[mid];
		}

		// Check if element at (mid - 1) is maximum element
		// Consider the cases like {4, 5, 1, 2, 3}
		if (mid > low && arr[mid] < arr[mid - 1]) {
			return arr[mid - 1];
		}

		// Decide whether we need to go to
		// the left half or the right half
		if (arr[low] > arr[mid]) {
			return findMax(arr, low, mid - 1);
		} else {
			return findMax(arr, mid + 1, high);
		}
	}

}
