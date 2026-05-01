package array;


public class MaximumSubArray1 {
	public static void main(String[] args) {
		int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int result = maximumSubArray(nums);
		System.out.println("result is "+result);
		
	}

	private static int maximumSubArray(int [] nums) {
		int curr=0;
		int res =0;
		for(int i=0; i< nums.length;i++) {
		  curr = curr + nums[i];
			if(curr < 0) {
				curr =0;
			}else {
				res = Math.max(res, curr);
			}
		}
		
		return res;
	}
}


/*
nums =[-2,1,-3,4,-1,2,1-5,4];
output =6

4,-1,2,1

*/