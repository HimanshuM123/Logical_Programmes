package codingInterview;

//Don't use mod or bitwise operations
public class OddOrEven {

	public static void main(String[] args) {
		int n = 55;

		if (2 * (n / 2) == n) {
			System.out.println("Number is Even");
		} else {
			System.out.println("Number is Odd");
		}
	}

}
