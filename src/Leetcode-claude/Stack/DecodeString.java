/*
 * LeetCode 394: Decode String
 *
 * Problem: Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets
 * is repeated exactly k times. k is guaranteed to be a positive integer.
 * You may assume the input string is always valid.
 *
 * Example: Input: s = "3[a]2[bc]" -> Output: "aaabcbc"
 *          Input: s = "3[a2[c]]" -> Output: "accaccacc"
 *
 * Approach: Stack
 * - Use stack to store characters and numbers
 * - When encountering ']', pop until '[' to get the encoded string
 * - Pop number and repeat the string
 * - Push result back to stack
 *
 * Time Complexity: O(n) - process each character once
 * Space Complexity: O(n) - for stack
 */

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";

        Stack<Object> stack = new Stack<>();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the number
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // Push number and '[' to stack
                stack.push(num);
                stack.push(c);
                num = 0;
            } else if (c == ']') {
                // Pop until '[' to get the encoded string
                StringBuilder temp = new StringBuilder();

                while (stack.peek() instanceof String) {
                    temp.insert(0, (String) stack.pop());
                }

                stack.pop(); // Remove '['
                int count = (int) stack.pop();

                // Repeat the string
                StringBuilder decoded = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    decoded.append(temp);
                }

                stack.push(decoded.toString());
            } else {
                // It's a character
                if (stack.isEmpty() || !(stack.peek() instanceof String)) {
                    stack.push(String.valueOf(c));
                } else {
                    stack.push((String) stack.peek() + c);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, (String) stack.pop());
        }

        return result.toString();
    }

    // Cleaner approach using separate stacks
    public String decodeStringClean(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(current);
                current = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int count = numStack.pop();
                StringBuilder prev = strStack.pop();
                StringBuilder temp = new StringBuilder();

                for (int i = 0; i < count; i++) {
                    temp.append(current);
                }

                current = prev.append(temp);
            } else {
                current.append(c);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        DecodeString sol = new DecodeString();

        System.out.println(sol.decodeStringClean("3[a]2[bc]"));       // aaabcbc
        System.out.println(sol.decodeStringClean("3[a2[c]]"));        // accaccacc
        System.out.println(sol.decodeStringClean("2[abc]3[cd]ef"));   // abcabccdcdcdef
        System.out.println(sol.decodeStringClean("a2[2[y]pq4[2[jk]e1[z]]]"));
    }
}
