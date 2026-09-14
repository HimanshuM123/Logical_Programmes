package maang;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int maxarea = maxArea(height);
		System.out.println(maxarea);

	}

	private static int maxArea(int[] height) {

		int left = 0;
		int right = height.length - 1;
		int maxWater = 0;

		while (left < right) {
			maxWater = Math.max(maxWater, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxWater;

	}

}


//Time: O(n) | Space: O(1)