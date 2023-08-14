package practice2;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 8;
		for (int i = 0; i < n; i++) {
			System.out.print(fib(i) + " ");
		}
	}

	private static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	// 8 -> 0 1 1 2 3 5 8 13
}
