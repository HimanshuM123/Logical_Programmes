package algorithmRecursion;

public class MeanOfArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int res = mean(arr, 0);
		System.out.println("The mean is " + res);
	}

	private static int mean(int[] arr, int index) {
		int sum = sum(arr, 0);
		return sum / arr.length;

	}

	private static int sum(int[] arr, int index) {
		if (index == arr.length) {
			return 0;
		}
		int sum = sum(arr, index + 1) + arr[index];
		return sum;

	}

}
