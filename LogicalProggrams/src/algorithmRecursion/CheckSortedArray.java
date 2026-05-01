package algorithmRecursion;

public class CheckSortedArray {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 9, 8 };
		boolean result = isSorted(arr, 0);
		if (result) {
			System.out.println("The array is sorted");
		} else {
			System.out.println("The array is NOT  sorted");
		}
	}

	private static boolean isSorted(int arr[], int index) {
		if (index == arr.length - 1) {
			return true;
		}

		return arr[index] < arr[index + 1] && isSorted(arr, index + 1);
	}

}
