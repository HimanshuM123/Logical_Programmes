package myPkg;

public class SumOfDigits {
	public static void main(String[] args) {
		int result = sum(38);
		System.out.println(result);
	}

	private static int sum(int n) {
		int sum = 0;
		while (n > 0 || sum > 9) {
			if (n == 0) {
				n = sum;
				sum = 0;
			}
			sum = sum + n % 10;
			n = n / 10;

		}
		return sum;

	}

}

/*
 * 38 => 11 =>2
 * 
 */