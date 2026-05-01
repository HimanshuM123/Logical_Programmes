package backtracking;
import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        Set<Pair<Integer, Integer>> path = new HashSet<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0, path)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i, Set<Pair<Integer, Integer>> path) {
        if (i == word.length()) {
            return true;
        }
        if (
            r < 0 || c < 0 || 
            r >= board.length || c >= board[0].length || 
            board[r][c] != word.charAt(i) || 
            path.contains(new Pair<>(r, c))
        ) {
            return false;
        }

        path.add(new Pair<>(r, c));
        boolean res = (
            dfs(board, word, r + 1, c, i + 1, path) ||
            dfs(board, word, r - 1, c, i + 1, path) ||
            dfs(board, word, r, c + 1, i + 1, path) ||
            dfs(board, word, r, c - 1, i + 1, path)
        );
        path.remove(new Pair<>(r, c));
        return res;
    }

    public static void main(String[] args) {
    	WordSearch solution = new WordSearch();

        char[][] board1 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        System.out.println("Example 1:");
        System.out.println(solution.exist(board1, word1)); // Output: true

        char[][] board2 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word2 = "SEE";
        System.out.println("Example 2:");
        System.out.println(solution.exist(board2, word2)); // Output: true

        char[][] board3 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word3 = "ABCB";
        System.out.println("Example 3:");
        System.out.println(solution.exist(board3, word3)); // Output: false
    }
}

 class Pair<T1, T2> {
	Pair(){}
	
	Pair(int r, int c){
		
	}

}


/*
Target = ABCCED

A B C E 
S F C S
A D E E 

*/