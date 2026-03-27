package codingInterview;

public class RemoveDuplicatesInSortedArray {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 3, 3, 3, 4, 4 };
		int result = removeDuplicates(arr);
		System.out.println(result);
	}

	private static int removeDuplicates(int[] arr) {
		int i = 0, j = 0;
		while (j < arr.length) {
			if (arr[i] == arr[j]) {
				j++;
			} else {
				i++;
				arr[i] = arr[j];
			}
		}
		return i + 1;
	}

}
