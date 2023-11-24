package matrix;

import java.util.Arrays;

public class SortMatrix {

	private static void printMat(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}

	}

	static void sortMat(int mat[][]) {
		int n = 3;
		int temp[] = new int[n * n];
		int k = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[k++] = mat[i][j];
			}
		}

		Arrays.sort(temp);
		k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = temp[k++];
			}
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 5, 4, 7 }, { 1, 3, 8 }, { 2, 9, 6 } };
		int n = 3;
		System.out.println("Original Matrix:");
		printMat(mat);
		System.out.println("Sorted Matrix:");
		sortMat(mat);
		printMat(mat);
	}

}
