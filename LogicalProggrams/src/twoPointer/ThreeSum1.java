package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum1 {
	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };

		List<List<Integer>> result = threeSum(arr);
		System.out.println(Arrays.asList(result));

	}

	public static List<List<Integer>> threeSum(int[] nums) {

		Set<List<Integer>> result = new HashSet<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {

			int x = nums[i];
			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {

				int sum = x + nums[left] + nums[right];
				if (sum < 0) {
					left++;
				} else if (sum > 0) {
					right--;
				} else {
					List<Integer> triplet = new ArrayList<>();
					triplet.add(x);
					triplet.add(nums[left]);
					triplet.add(nums[right]);

					result.add(triplet);
					left++;
					right--;

				}

			}

		}
		return new ArrayList<>(result);

	}

}
