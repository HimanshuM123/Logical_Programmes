package sorting;

public class BinarySearch {
	public static void main(String[] args) {
		int[] numbers = { -11, -5, 1, 3, 6, 9, 18, 25, 33 };

		int x = 1;

		System.out.println(binarySearchRecur(numbers, x, 0, numbers.length - 1));

	}

	public static boolean binarySearchRecur(int[] array, int x, int left, int right) {

		if (left > right) {
			return false;
		}

		int mid = left + (right - left) / 2;

		if (x == array[mid]) {
			return true;
		} else if (x < array[mid]) {
			return binarySearchRecur(array, x, left, mid - 1);
		} else {
			return binarySearchRecur(array, x, mid + 1, right);
		}

	}
	// time complexity O(logn)
}
