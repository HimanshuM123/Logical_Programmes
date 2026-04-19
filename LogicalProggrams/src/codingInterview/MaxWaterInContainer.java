package codingInterview;

public class MaxWaterInContainer {
	public static void main(String[] args) {
		int[] arr = { 8, 6, 2, 5, 4, 8, 3, 7 };
		int result = maxWater(arr);
		System.out.println(result);
	}

	private static int maxWater(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int maxWaterArea = 0;

		while (left < right) {

			int width = right - left;
			int height = Math.min(arr[left], arr[right]);
			int area = width * height;
			maxWaterArea = Math.max(maxWaterArea, area);
			if (arr[left] <= arr[right]) {
				left++;
			} else {
				right--;
			}

			

		}
		System.out.println(left+" "+right);
		return maxWaterArea;

	}

}



/*


8,6,2,5,4,8,3,7
0,1,2,3,4,5,6,7

The best container is formed by:

index 0 (height 8)
index 7 (height 7)

So:

height = 7
width = 7
area = 49

  Time Complexity = O(n)
  Space complexity =O(1)


*/
