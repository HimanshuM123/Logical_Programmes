package leetCode;

class SumTwoNums {
	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String args[]) {
//		int nums[] = { 2, 7, 11, 15 };
		int nums[] = { 11, 15,2, 7 };

		int target = 9;
		int out[] = twoSum(nums, target);
		for (int k = 0; k < out.length; k++) {
			System.out.println(out[k]);
		}
	}
}
