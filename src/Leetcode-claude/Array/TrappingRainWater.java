/*
 * LeetCode 42: Trapping Rain Water
 *
 * Problem: Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 *
 * Example: Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] -> Output: 6
 *
 * Approach: Two Pointers with Left/Right Max
 * - Track maximum height seen from left and right at each position
 * - Water trapped = min(leftMax, rightMax) - height[i]
 * - Use two pointers approach for O(1) space
 *
 * Time Complexity: O(n) - single pass
 * Space Complexity: O(1) - only pointers and variables (not counting output)
 */

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // Process from left
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                // Process from right
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    // Alternative approach using arrays (clearer but O(n) space)
    public int trapWithArrays(int[] height) {
        if (height == null || height.length < 3) return 0;

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMax
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill rightMax
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate water
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

    public static void main(String[] args) {
        TrappingRainWater sol = new TrappingRainWater();

        System.out.println(sol.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
        System.out.println(sol.trap(new int[]{4, 2, 0, 3, 2, 5}));                    // 9
        System.out.println(sol.trap(new int[]{}));                                    // 0
    }
}
