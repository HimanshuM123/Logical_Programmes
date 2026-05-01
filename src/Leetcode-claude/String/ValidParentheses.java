/*
 * LeetCode 20: Valid Parentheses
 *
 * Problem: Given a string s containing just characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * Valid if: 1) Every opening bracket has corresponding closing bracket
 *           2) Closing brackets are in correct order
 *
 * Example: Input: s = "()[]{}" -> Output: true
 *
 * Approach: Stack
 * - Push opening brackets to stack
 * - For closing brackets, check if stack top matches
 * - Stack should be empty at end (all brackets matched)
 *
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(n) - worst case all opening brackets
 */

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 != 0) return false; // Odd length can't be valid

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // Closing bracket - check if stack is empty or top doesn't match
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses sol = new ValidParentheses();

        System.out.println(sol.isValid("()"));           // true
        System.out.println(sol.isValid("()[]{"));        // false
        System.out.println(sol.isValid("([)]"));         // false
        System.out.println(sol.isValid("{[]}"));         // true
        System.out.println(sol.isValid(""));             // true
        System.out.println(sol.isValid("(]"));           // false
    }
}
