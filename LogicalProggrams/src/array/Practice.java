package array;

import java.util.HashSet;
import java.util.Set;

public class Practice {
	public static void main(String[] args) {
		 int[] nums = {49, 1, 3, 200, 2,2, 4, 70, 5};
	    	
	        int maxLength = findLengthOfLongestContiguousSubarray(nums);
	        System.out.println("Length of the longest contiguous subarray: " + maxLength);
	}
	
	private static int findLengthOfLongestContiguousSubarray(int[] nums) {
		int maxLength = 0;
		Set<Integer> set = new HashSet<>();
		for (Integer obj : nums) {
			set.add(obj);
		}

		for (Integer obj : nums) {
			int len = 0;
			while (set.contains(obj++)) {
				len++;

			}
			maxLength = Math.max(maxLength, len);
		}

		return maxLength;

	}

}
