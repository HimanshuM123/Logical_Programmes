package codingInterview;
//Day 20
public class MaximumSubArraySum {
	public static void main(String[] args) {
		//return subarray sum which is highest
		int [] nums = {1,-3,4,-1,2,1,-5,4};
		int result = maxSubArray(nums);
		
		System.out.println(result); // 6  [4,1-,2,1]
		
	}
	
	private static int maxSubArray(int [] nums) {
		int max = nums[0];
		int s = nums[0];
		
		for(int i=1;i< nums.length; i++) {
			
			int nE = nums[i];
			s=Math.max(nE, s+nE);
			max = Math.max(max, s);
			
			
		}
		return max;
		
	}

}
