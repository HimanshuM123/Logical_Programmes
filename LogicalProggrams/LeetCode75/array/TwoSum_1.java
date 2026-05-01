package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
	public static void main(String[] args) {
		int[] arr = { 2, 7, 11, 15 };
		int[] result = twoSum(arr, 9);
		System.out.println(Arrays.toString(result));

	}

	private static int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> hm = new HashMap<>();
		int[] resultArr = { 0, 0 };

		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			int diff = target - val;
			if (hm.containsKey(diff)) {
				resultArr[0] = i;
				resultArr[1] = hm.get(diff);

			}
			hm.put(val, i);
		}

		return resultArr;

	}

}

/*
 * 
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because
 * nums[0] + nums[1] == 9, we return [0, 1].
 * 
 */