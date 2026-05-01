package codingInterview;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 0, 1, 1, 0};
        System.out.println(findMaxLength(nums)); // Output: 6 -->0, 1, 0, 0, 1, 1
	}
	
	private static int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>(); // sum -> index
		map.put(0, -1);// Important!

		int sum = 0;
		int maxLength = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				sum = sum - 1;
			} else {
				sum = sum + 1;
			}

			if (map.containsKey(sum)) {
				int length = i - map.get(sum);
				maxLength = Math.max(maxLength, length);
			} else {
				map.put(sum, i);
			}

		}
		return maxLength;

	}

}


/*

| i | nums[i] | value | sum | map contains sum? | action                | maxLength |
| - | ------- | ----- | --- | ----------------- | --------------------- | --------- |
| 0 | 0       | -1    | -1  | ❌                 | store (-1 → 0)        | 0         |
| 1 | 1       | +1    | 0   | ✅                 | length = 1 - (-1) = 2 | 2         |
| 2 | 0       | -1    | -1  | ✅                 | length = 2 - 0 = 2    | 2         |
| 3 | 0       | -1    | -2  | ❌                 | store (-2 → 3)        | 2         |
| 4 | 1       | +1    | -1  | ✅                 | length = 4 - 0 = 4    | 4         |
| 5 | 1       | +1    | 0   | ✅                 | length = 5 - (-1) = 6 | **6 ✅**   |
| 6 | 0       | -1    | -1  | ✅                 | length = 6 - 0 = 6    | 6         |



*/