/*
 * LeetCode 73: Set Matrix Zeroes
 *
 * Problem: Given an m x n integer matrix, if an element is 0, set its entire row and column to 0.
 * Do it in-place (must modify the input matrix).
 * Challenge: O(1) space complexity without using extra array.
 *
 * Example: Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 *          Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Approach: Use First Row and Column as Markers
 * - Use matrix[0][j] and matrix[i][0] as markers for rows and columns
 * - Handle first row and first column separately
 * - Two passes: mark zeros, then set zeros
 *
 * Time Complexity: O(m * n) - two passes
 * Space Complexity: O(1) - only use matrix itself
 */

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row and column should be zero
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Mark zeros using first row and column
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set rows to zero
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set columns to zero
        for (int j = 1; j < cols; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle first row
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Handle first column
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes sol = new SetMatrixZeroes();

        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        sol.setZeroes(matrix1);
        printMatrix(matrix1);
        // [[1,0,1],[0,0,0],[1,0,1]]

        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        sol.setZeroes(matrix2);
        printMatrix(matrix2);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
