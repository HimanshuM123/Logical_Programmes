/*
 * LeetCode 739: Daily Temperatures
 *
 * Problem: Given an array of integers temperatures representing the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait
 * after the ith day to get a warmer temperature.
 * If no future day is warmer, put 0.
 *
 * Example: Input: temperatures = [73,74,75,71,69,72,76,73]
 *          Output: [1,1,4,2,1,1,0,0]
 *
 * Approach: Monotonic Stack
 * - Use stack to store indices of temperatures in decreasing order
 * - For each temperature, pop all smaller temperatures from stack
 * - Distance between indices gives the answer
 *
 * Time Complexity: O(n) - each element pushed and popped once
 * Space Complexity: O(n) - for stack
 */

import java.util.Stack;
import java.util.Arrays;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];

        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // Store indices

        for (int i = 0; i < n; i++) {
            // Pop all elements smaller than current temperature
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }

            // Push current index
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures sol = new DailyTemperatures();

        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        // [1,1,4,2,1,1,0,0]

        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[]{30, 40, 50, 60})));
        // [1,1,1,0]

        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[]{30, 60, 90})));
        // [1,1,0]
    }
}
