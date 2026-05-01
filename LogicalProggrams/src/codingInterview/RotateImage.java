package codingInterview;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        int n = matrix.length;
        
        // Transpose the matrix: swap matrix[i][j] and matrix[j][i]
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {  // Start from j = i + 1 to avoid re-swapping
                swap(matrix, i, j, j, i);
            }
        }
        
        // Reverse each row: swap matrix[i][j] and matrix[i][n-j-1]
        for (int i = 0; i < n; i++) {
            int j = 0, k = n - 1;
            while (j < k) {
                swap(matrix, i, j, i, k);
                j++;
                k--;
            }
        }
        
        // Print the rotated matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // Swap helper method that modifies the matrix
    private static void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }
}


/*

1  2  3         7  4  1
4  5  6    =>  	8  5  2
7  8  9         9  6  3

1  2  3                     1  4  7                 7  4  1
4  5  6    =>  transpose->	2  5  8 ->  Reverse ->  8  5  2
7  8  9                     3  6  9                 9  6  3




*/

