package algorithmRecursion;

public class SumOfArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int result = sumOfArray(arr, 0);
		System.out.println("The Sum is " + result);
	}

	private static int sumOfArray(int[] arr, int index) {
		if (index == arr.length) {
			return 0;
		}
		return sumOfArray(arr, index + 1) + arr[index];

	}

}
