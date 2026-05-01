package codingInterview;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int k = 3;

		System.out.println(getSumArrayCount(arr, k));

	}

	private static int getSumArrayCount(int[] nums, int k) {

		int count = 0;
		int prefixSum = 0;

		Map<Integer, Integer> hm = new HashMap<>();
		hm.put(0, 1);
		for (int num : nums) {

			prefixSum = prefixSum + num;
			if (hm.containsKey(prefixSum - k)) {
				count = count + hm.get(prefixSum - k);
			}

			hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);

		}

		return count;
	}

}
