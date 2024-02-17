package practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class Practice {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 35, 50, 75, 80 };
		int[] result = findPair(arr, 70);
		System.out.println(Arrays.toString(result));
	}

	private static int[] findPair(int[] arr, int target) {
		int[] result = new int[2];

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int sum = arr[left] + arr[right];

			if (sum > target) {
				right--;
			}
			if (sum < target) {
				left++;
			} if(sum ==target) {
				result[0] = arr[left];
				result[1] = arr[right];
				break;
			}

		}

		return result;
	}
}
