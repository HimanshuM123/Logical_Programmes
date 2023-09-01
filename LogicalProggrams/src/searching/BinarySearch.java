package searching;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 2, 5, 8, 12, 16, 19, 30, 42, 52, 67 };
		int result = binarySearch(arr, 42);
		System.out.println(result);

	}

	private static int binarySearch(int[] arr, int element) {
		int low = 0;
		int high = arr.length - 1;

		int mid;
		while (low < high) {
			mid = low + (high - low) / 2;
			if (element == arr[mid]) {
				return mid;
			} else if (element > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}
		return -1;
	}

}
