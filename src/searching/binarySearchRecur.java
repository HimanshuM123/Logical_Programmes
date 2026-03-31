package searching;

public class binarySearchRecur {
	public static void main(String[] args) {
		int arr[] = { 2, 5, 8, 12, 16, 19, 30, 42, 52, 67 };
		int result = binarySearchRecur(arr, 42, 0, arr.length - 1);
		System.out.println("The element position is " + result);

	}

	private static int binarySearchRecur(int[] arr, int element, int low, int high) {

		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (element == arr[mid]) {
			return mid;
		} else if (element > mid) {
			return binarySearchRecur(arr, element, mid + 1, high);
		} else if (element < mid) {
			return binarySearchRecur(arr, element, low, mid - 1);
		}
		return -1;

	}

}
