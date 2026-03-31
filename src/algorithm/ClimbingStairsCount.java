package algorithm;

public class ClimbingStairsCount {
	public static void main(String[] args) {
		int n = 6;
		System.out.println(countPaths(n, new int[n + 1]));
	}

	private static int countPaths(int n, int[] qb) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		if (qb[n] > 0) {
			return qb[n];
		}
		int nm1 = countPaths(n - 1, qb);
		int nm2 = countPaths(n - 2, qb);
		int nm3 = countPaths(n - 3, qb);

		int count = nm1 + nm2 + nm3;
		qb[n] = count;
		return count;

	}
}
