package matrix;

public class SortMatrix {

	private static void printMat(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println();
		}

	}
	
	private static void sortMat(int[][] arr) {
		int temp[]= new int[arr.length];
		int k=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				temp[k] =arr[i][j];
				k++;
			}
			
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 5, 4, 7 }, { 1, 3, 8 }, { 2, 9, 6 } };
		int n = 3;

		System.out.println("Original Matrix:");
		printMat(mat);
	}

}
