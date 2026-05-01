/*
 * LeetCode 84: Largest Rectangle in Histogram
 *
 * Problem: Given an array of integers heights representing the histogram's bar height,
 * return the area of the largest rectangle in the histogram.
 *
 * Example: Input: heights = [2,1,5,6,2,3]
 *          Output: 10 (height 5 and 6 can form rectangle with width 2)
 *
 * Approach: Monotonic Stack
 * - Maintain stack of indices in increasing order of heights
 * - When encountering bar shorter than stack top, pop and calculate area
 * - For each bar, width extends from current position to position after top
 *
 * Time Complexity: O(n) - each bar pushed and popped once
 * Space Complexity: O(n) - for stack
 */

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<>(); // Store indices
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            // Pop all bars taller than current
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()];

                // Width: from element after new top to current position - 1
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }

            stack.push(i);
        }

        // Pop remaining elements
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int w = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram sol = new LargestRectangleInHistogram();

        System.out.println(sol.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));  // 10
        System.out.println(sol.largestRectangleArea(new int[]{2, 4}));              // 4
        System.out.println(sol.largestRectangleArea(new int[]{0, 9}));              // 9
    }
}
