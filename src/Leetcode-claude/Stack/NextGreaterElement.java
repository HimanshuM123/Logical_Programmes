/*
 * LeetCode 496: Next Greater Element I
 *
 * Problem: The next greater element of some element x in an array is the first element
 * to the right of x that is greater than x.
 * Given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2,
 * for each element nums1[i], find the next greater element in nums2.
 * If no next greater element exists, the answer is -1.
 *
 * Example: Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 *          Output: [-1,3,-1]
 *
 * Approach: Monotonic Stack + HashMap
 * - Use stack to find next greater element for each number in nums2
 * - Store results in HashMap
 * - Look up results for nums1 elements
 *
 * Time Complexity: O(n + m) where n = len(nums2), m = len(nums1)
 * Space Complexity: O(n) for stack and HashMap
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Process nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];

            // Pop all elements smaller than current
            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
            }

            // Current element's next greater is top of stack (if exists)
            if (!stack.isEmpty()) {
                map.put(num, stack.peek());
            } else {
                map.put(num, -1);
            }

            stack.push(num);
        }

        // Build result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement sol = new NextGreaterElement();

        System.out.println(Arrays.toString(sol.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        // [-1, 3, -1]

        System.out.println(Arrays.toString(sol.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
        // [3, -1]
    }
}
