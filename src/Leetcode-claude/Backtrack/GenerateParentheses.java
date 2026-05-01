/*
 * LeetCode 22: Generate Parentheses
 *
 * Problem: Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 *
 * Example: Input: n = 3
 *          Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Approach: Backtracking with Valid Count Tracking
 * - Track count of open and close parentheses
 * - Can add '(' if open count < n
 * - Can add ')' if close count < open count
 * - When both reach n, we have a valid combination
 *
 * Time Complexity: O(4^n / sqrt(n)) - Catalan number
 * Space Complexity: O(n) - recursion depth
 */

import java.util.List;
import java.util.ArrayList;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, 0, 0, "", result);
        return result;
    }

    private void backtrack(int n, int open, int close, String current, List<String> result) {
        // Base case: both open and close reach n
        if (open == n && close == n) {
            result.add(current);
            return;
        }

        // Add '(' if open < n
        if (open < n) {
            backtrack(n, open + 1, close, current + "(", result);
        }

        // Add ')' if close < open (ensures valid parentheses)
        if (close < open) {
            backtrack(n, open, close + 1, current + ")", result);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses sol = new GenerateParentheses();

        System.out.println(sol.generateParenthesis(3));
        // ["((()))","(()())","(())()","()(())","()()()"]

        System.out.println(sol.generateParenthesis(1));
        // ["()"]

        System.out.println(sol.generateParenthesis(4));
    }
}
