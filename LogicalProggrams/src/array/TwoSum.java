package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int[] arr = {  11, 15,2, 7 };
		int target = 9;
		int [] indexes = twoSumIndex(arr, target);
		System.out.println(Arrays.toString(indexes));
		
	}

	private static int[] twoSumIndex(int arr[], int target) {
		Map<Integer, Integer> hm = new HashMap<>();
		int []  resultArr = {0,0};
		for (int i = 0; i < arr.length; i++) {
			hm.put(arr[i], i);
		}
		for (int i = 0; i < arr.length; i++) {
			int val = target - arr[i];
			if (hm.containsKey(val)) {
				resultArr[0] = i;
				resultArr[1] = hm.get(val);
				return resultArr;
			}
		}
		return resultArr;
	}

}
/*
 * 2 -> 0 7 -> 1 11- > 2 15 -> 3
 */
