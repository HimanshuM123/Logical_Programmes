package array;

public class MaximumSubArray {
	public static void main(String[] args) {
		int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int result = maximumSubArray(nums);
		System.out.println("result is "+result);
		
	}

	private static int maximumSubArray(int [] nums) {
		int res = nums[0];
		int curr_sum =0;
		
		for(int i=0; i<nums.length;i++) {
			curr_sum = Math.max(curr_sum, 0);
			curr_sum = curr_sum +nums[i];
			res = Math.max( res,curr_sum);
		}
		return res;
	}
}


/*
nums =[-2,1,-3,4,-1,2,1-5,4];
output =6

4,-1,2,1

*/