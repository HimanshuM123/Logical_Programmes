package algorithmRecursion;

public class BinarySearchRecur {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(binaryRecur(arr, 0, arr.length - 1, 8));
	}

	public static int binaryRecur(int[] arr, int low, int high, int value) {
		int mid = low + (high - low) / 2;
		if (arr[mid] == value) {
			return mid;
		} else if (arr[mid] < value) {
			return binaryRecur(arr, mid + 1, high, value);
		} else {
			return binaryRecur(arr, low, mid - 1, value);
		}
	}
}
