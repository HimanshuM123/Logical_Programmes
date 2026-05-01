package codingInterview;

public class SearchIn2DArray {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int k = 5;
		
		System.out.println(search(matrix,k));
	}

	private static boolean search(int[][] mat, int key) {

		int n = mat.length;
		int m = mat[0].length;

		int start = 0;
		int end = m * n - 1;

		while (start <= end) {

			int mid = start + (end - start) / 2;
			int r = mid / m;//row index
			int c = mid % m;//column index

			if (mat[r][c] == key) {
				return true;
			} else if (key > mat[r][c]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}

		return false;

	}

}
