package codingInterview;

import java.util.HashMap;
import java.util.Map;

public class SubarraysDivByK {
	
	public static void main(String[] args) {
		int [] arr = {1,4,3,2,1};
		int k=5;
		
		System.out.println(getSumArrayCount(arr,k));
				
	}
	
	
	private static int getSumArrayCount(int[] nums, int k) {

		int prefixSum = 0;
		int count = 0;

		Map<Integer, Integer> hm = new HashMap<>();
		hm.put(0, 1);

		for (int num : nums) {
			prefixSum = prefixSum + num;

			int remainder = prefixSum % k;

			if (remainder < 0) {
				remainder = remainder + k;
			}
			if (hm.containsKey(remainder)) {
				count += hm.get(remainder);
			}

			hm.put(remainder, hm.getOrDefault(remainder, 0) + 1);

		}

		return count;

	}

}
