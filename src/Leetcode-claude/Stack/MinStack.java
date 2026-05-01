/*
 * LeetCode 155: Min Stack
 *
 * Problem: Design a stack that supports push, pop, top, and retrieving the minimum element
 * in constant time.
 * All operations must be O(1) time complexity.
 *
 * Example: MinStack minStack = new MinStack();
 *          minStack.push(-2);
 *          minStack.push(0);
 *          minStack.push(-3);
 *          minStack.getMin(); // return -3
 *
 * Approach: Two Stacks
 * - Stack 1: Store all elements
 * - Stack 2: Store minimum values
 * - When pushing, push to both stacks (min stack stores min at each level)
 * - When popping, pop from both
 *
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(n) for two stacks
 */

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        // Push minimum to minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        // Pop from both stacks if top of stack equals top of minStack
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());  // -3
        minStack.pop();
        System.out.println(minStack.top());     // 0
        System.out.println(minStack.getMin());  // -2
    }
}
