package algorithmRecursion;

public class PowerLogarithmic {
	public static void main(String[] args) {
		
		System.out.println(powerLogarithmic(2, 3));
	}

	private static int powerLogarithmic(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int y = powerLogarithmic(x, n / 2) * powerLogarithmic(x, n / 2);
		if (n % 2 == 1) {
			y = x * powerLogarithmic(x, n / 2) * powerLogarithmic(x, n / 2);
		}
		return y;
	}
}
