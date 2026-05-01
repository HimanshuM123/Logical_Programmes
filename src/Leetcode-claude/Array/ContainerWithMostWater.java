/*
 * LeetCode 11: Container With Most Water
 *
 * Problem: You are given an integer array height of length n.
 * There are n vertical lines drawn at indices 0 to n-1.
 * Find two lines that together with the x-axis form a container such that
 * the container holds the most water. Return the maximum area.
 *
 * Example: Input: height = [1,8,6,2,5,4,8,3,7] -> Output: 49
 *
 * Approach: Two Pointers
 * - Start with widest container (first and last lines)
 * - Area = width * min(height[left], height[right])
 * - Move the pointer pointing to smaller height (to possibly get taller line)
 *
 * Time Complexity: O(n) - single pass with two pointers
 * Space Complexity: O(1) - only pointers and variables
 */

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Width and height of current container
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;

            maxArea = Math.max(maxArea, area);

            // Move pointer pointing to shorter line
            // (no point moving the taller line, it can only decrease area)
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();

        System.out.println(sol.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(sol.maxArea(new int[]{1, 1}));                      // 1
        System.out.println(sol.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));     // 17
    }
}
