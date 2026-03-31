package algorithmRecursion;

public class SumOfDigits {
	public static void main(String[] args) {
		int num = 12345;
		int result = sumOfDigits(num);
		System.out.println("The sum of digits is " + result);
	}

	private static int sumOfDigits(int n) {
		if (n == 0) {
			return 0;
		}
		return (n % 10 + sumOfDigits(n / 10));
	}

}
