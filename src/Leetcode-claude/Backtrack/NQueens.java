/*
 * LeetCode 51: N-Queens
 *
 * Problem: The N-Queens problem is the problem of placing N queens on an n×n chessboard
 * such that no two queens attack each other. Return all distinct solutions to the N-Queens puzzle.
 *
 * Example: Input: n = 4
 *          Output: [[".Q..",
 *                    "...Q",
 *                    "Q...",
 *                    "..Q."],
 *                   ["..Q.",
 *                    "Q...",
 *                    "...Q",
 *                    ".Q.."]]
 *
 * Approach: Backtracking with Sets to track constraints
 * - Place queens row by row
 * - Track occupied columns and diagonals
 * - Backtrack when placement violates constraints
 *
 * Time Complexity: O(N!) - roughly N! placements to check
 * Space Complexity: O(N) - recursion depth + constraint sets
 */

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, 0, n, result);
        return result;
    }

    private void backtrack(char[][] board, int row, int n, List<List<String>> result) {
        // Base case: all queens placed
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }

        // Try placing queen in each column of current row
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                // Place queen
                board[row][col] = 'Q';

                // Recurse to next row
                backtrack(board, row + 1, n, result);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check left diagonal (up-left)
        int i = row - 1, j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        // Check right diagonal (up-right)
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        NQueens sol = new NQueens();

        System.out.println("4-Queens solutions:");
        List<List<String>> result = sol.solveNQueens(4);
        for (List<String> solution : result) {
            System.out.println("---");
            for (String row : solution) {
                System.out.println(row);
            }
        }
    }
}
