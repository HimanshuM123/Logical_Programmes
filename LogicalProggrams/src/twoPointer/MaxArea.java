package twoPointer;

public class MaxArea {

	public static void main(String[] args) {

		int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int left = 0;
		int right = arr.length - 1;
		int max_area =Integer.MIN_VALUE;

		while (left < right) {
			int small = arr[left] > arr[right] ? arr[right] : arr[left];
			int new_area = small * (right - left);
			max_area = Math.max(max_area, new_area);
			if (arr[left] > arr[right]) {
				right--;
			} else {
				left++;
			}
		}

		System.out.println(max_area);

	}

}

/*

8         7
7*7=49

*/