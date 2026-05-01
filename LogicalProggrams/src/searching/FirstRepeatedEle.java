package searching;

public class FirstRepeatedEle {
	public static void main(String[] args) {
		int arr[] = { 3, 7, 4, 1, 4, 6, 8, 7, 8 };

		int result = firstRepeated(arr);
		System.out.println("The result is " + result);

	}

	private static int firstRepeated(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					return arr[i];
				}
			}
		}
		return -1;

	}
}
