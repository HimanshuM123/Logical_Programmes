package myPkg;

public class MissingNumber {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5 };
		int count = 5;

		int expectedSum = 5 * (5 + 1) / 2;

		int actualSum = 0;

		for (int obj : arr) {
			actualSum = actualSum + obj;
		}

		int missingNumber = expectedSum - actualSum;
		System.out.println(missingNumber);

	}
}
