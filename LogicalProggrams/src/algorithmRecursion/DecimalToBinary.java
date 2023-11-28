package algorithmRecursion;

public class DecimalToBinary {
	public static void main(String[] args) {
		int binary = toBinary(17);
		System.out.println("The result is " + binary);
	}

	private static int toBinary(int num) {
		if (num == 0) {
			return 0;
		}

		return num % 2 + 10 * toBinary(num / 2);

	}
}
