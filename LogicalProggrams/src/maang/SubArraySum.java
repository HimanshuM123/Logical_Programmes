package maang;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 1 };
		int k = 2;

		int result = subarraySum(nums, k);
		System.out.println(result);

	}

	public static int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		int sum = 0;
		int count = 0;

		for (int num : nums) {
			sum = sum + num;

			if (map.containsKey(sum - k)) {
				count = count + map.get(sum - k);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;

	}

}

/*
 * 
 * Problem: Count the number of subarrays whose sum equals k.
 * 
 * Example:
 * 
 * Input: nums = [1,1,1], k = 2 Output: 2
 * 
 */