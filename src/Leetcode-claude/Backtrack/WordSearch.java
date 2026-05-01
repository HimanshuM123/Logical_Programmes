/*
 * LeetCode 79: Word Search
 *
 * Problem: Given an m x n grid of characters board and a string word,
 * return true if word exists in the grid. The word can be constructed from letters
 * of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * Example: Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 *          Output: true
 *
 * Approach: DFS Backtracking
 * - For each cell, perform DFS if it matches the first character
 * - Mark visited cells to avoid reuse
 * - Recursively search in 4 directions
 * - Backtrack by unmark visited
 *
 * Time Complexity: O(m * n * 4^L) where L is word length
 * Space Complexity: O(m * n) - visited array + O(L) - recursion depth
 */

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) return false;

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col,
                        int index, boolean[][] visited) {
        // Base case: all characters matched
        if (index == word.length()) {
            return true;
        }

        // Boundary check and visited check
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
            visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark as visited
        visited[row][col] = true;

        // Search in 4 directions
        boolean found = dfs(board, word, row + 1, col, index + 1, visited) ||
                       dfs(board, word, row - 1, col, index + 1, visited) ||
                       dfs(board, word, row, col + 1, index + 1, visited) ||
                       dfs(board, word, row, col - 1, index + 1, visited);

        // Backtrack
        visited[row][col] = false;

        return found;
    }

    public static void main(String[] args) {
        WordSearch sol = new WordSearch();

        char[][] board1 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println(sol.exist(board1, "ABCCED"));  // true
        System.out.println(sol.exist(board1, "SEE"));     // true
        System.out.println(sol.exist(board1, "ABCB"));    // false
    }
}
