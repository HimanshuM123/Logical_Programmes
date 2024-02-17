package array;

import java.util.Arrays;

public class SmallerNumbersThanCurrent {
	public static void main(String[] args) {
		int[] nums = { 8, 1, 2, 2, 3 };
		
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
		

	}

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] result = new int[nums.length];

		int buckets[] = new int[102];
		for (int num : nums) {
			buckets[num]++;
		}
		for (int i = 1; i < buckets.length; i++) {
			buckets[i] =buckets[i] + buckets[i - 1];
		}
		for (int i = 0; i < result.length; i++) {
		      if (nums[i] == 0) {
		        result[i] = 0;
		      }
		      else {
		    	  int temp = nums[i] - 1;
		        result[i] = buckets[temp];
		      }
		    }
		return result;

	}

}
//[4, 0, 1, 1, 3]
