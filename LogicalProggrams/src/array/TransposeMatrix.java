package array;

import java.util.Arrays;

public class TransposeMatrix {
	public static void main(String[] args) {
		int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(Arrays.deepToString(traspose(arr)));
//[[1, 4, 7], [2, 5, 8], [3, 6, 9]]

	}
	
	private static int [][] traspose(int [] [] A){
		int rows = A.length;
		int columns = A[0].length;
		int[][] new_matrix = new int [rows][columns];
		
		for(int i=0; i< rows; i++) {
			for(int j=0; j < columns ; j++) {
				new_matrix[j][i] = A[i][j];
			}
		}
		return new_matrix;
	}

}


/*

[
[1,2,3],
[4,5,6],
[7,8,9]

[1,4,7]
[2,5,8]
[3,6,9]

]




*/