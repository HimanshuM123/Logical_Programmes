package practice2;

public class MaxElement {
	public static void main(String[] args) {

		int[] arr = { 4, 29, 45, 0, 8, 36, 90 };

		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}

		}
		System.out.println("Maximum element is " + max);

	}
}
