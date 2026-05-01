/*
 * LeetCode 150: Evaluate Reverse Polish Notation
 *
 * Problem: Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /.
 * Each operand may be an integer or another expression.
 * Division always truncates towards zero.
 *
 * Example: Input: tokens = ["2","1","+","3","*"] -> Output: 9 (2 + 1 = 3, 3 * 3 = 9)
 *
 * Approach: Stack
 * - When encountering operand, push to stack
 * - When encountering operator, pop two operands, apply operator, push result
 * - Final result is the only element in stack
 *
 * Time Complexity: O(n) - process each token once
 * Space Complexity: O(n) - for stack
 */

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        String operators = "+-*/";

        for (String token : tokens) {
            if (!operators.contains(token)) {
                // It's a number
                stack.push(Integer.parseInt(token));
            } else {
                // It's an operator
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation sol = new EvaluateReversePolishNotation();

        System.out.println(sol.evalRPN(new String[]{"2", "1", "+", "3", "*"}));           // 9
        System.out.println(sol.evalRPN(new String[]{"4", "13", "5", "/", "+"}));         // 6
        System.out.println(sol.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})); // 22
    }
}
