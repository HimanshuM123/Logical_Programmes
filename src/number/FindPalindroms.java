package number;

public class FindPalindroms {

	public static void main(String[] args) {
		getPalindroms(4);
	}

	private static int reverse(int num) {
		int sum = 0;
		while (num > 0) {
			sum = sum * 10 + num % 10;
			num = num / 10;
		}
		return sum;

	}

	private static void getPalindroms(int num) {
		int H = (int) Math.pow(10, num) - 1;
		int L = (int) Math.pow(10, num - 1);

		for (int i = L; i < H; i++) {
			if (i == reverse(i)) {
				System.out.print(i + " ");
			}

		}

	}

}

/*
 * 
 * Find all palindrome numbers of given digits
 * 
 * Input: D = 1 Output: 1 2 3 4 5 6 7 8 9 Input: D = 2 Output: 11 22 33 44 55 66
 * 77 88 99
 * 
 */