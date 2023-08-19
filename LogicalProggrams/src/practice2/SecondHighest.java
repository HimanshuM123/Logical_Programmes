package practice2;

public class SecondHighest {
	public static void main(String[] args) {
		int arr[] = { 4, 6, 8, 2, 1, 3, 5, 9 };

		int max = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				secondHighest = max;
				max = arr[i];
			} else if (arr[i] > secondHighest) {
				secondHighest = arr[i];
			}
		}

		System.out.println("The second highest element is " + secondHighest);

	}
}
