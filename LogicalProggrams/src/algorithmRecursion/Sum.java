package algorithmRecursion;

public class Sum {
	public static void main(String[] args) {
		int result = sum(5);
		System.out.println("The sum is " + result);
	}

	private static int sum(int n) {
		if (n == 0) {
			return n;
		}
		return sum(n - 1) + n;
	}
}
