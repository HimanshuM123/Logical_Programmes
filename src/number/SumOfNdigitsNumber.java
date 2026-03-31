package number;

public class SumOfNdigitsNumber {
	public static void main(String[] args) {
		int result = sum(2, 7);
		System.out.println(result);

	}

	private static int sum(int num, int diviser) {
		int sum = 0;
		int H = (int) Math.pow(10, num) - 1;
		int L = (int) Math.pow(10, num - 1);
		for (int i = L; i <= H; i++) {
			if (i % diviser == 0) {
				sum = sum + i;
			}
		}
		return sum;
	}
}

/*
 * 
 * Sum of n digit numbers divisible by a given number Input : n = 2, number = 7
 * Output : 728 Explanation: There are thirteen n digit numbers that are
 * divisible by 7. Numbers are : 14+ 21 + 28 + 35 + 42 + 49 + 56 + 63 +70 + 77 +
 * 84 + 91 + 98.
 * 
 * Input : n = 3, number = 7 Output : 70336
 * 
 * Input : n = 3, number = 4 Output : 123300
 * 
 * 
 */