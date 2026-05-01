package dynamicProgramming;
import java.util.HashMap;
import java.util.Map;



public class TargetSum {
	
	public static void main(String[] args) {
		TargetSum obj = new TargetSum();
		int [] nums = {1,1,1,1,1}; int target = 3;
		int res =obj.findTargetSumWays(nums, target);
		System.out.println(res);//5
		
	}
	
	

	    public int findTargetSumWays(int[] nums, int target) {
	        Map<String, Integer> dp = new HashMap<>();  // (index, total) -> # of ways
	        
	        return backtrack(nums, target, 0, 0, dp);
	    }
	    
	    private int backtrack(int[] nums, int target, int i, int total, Map<String, Integer> dp) {
	        if (i == nums.length) {
	            return total == target ? 1 : 0;
	        }
	        
	        String key = i + "," + total;
	        if (dp.containsKey(key)) {
	            return dp.get(key);
	        }
	        
	        int add = backtrack(nums, target, i + 1, total + nums[i], dp);
	        int subtract = backtrack(nums, target, i + 1, total - nums[i], dp);
	        
	        dp.put(key, add + subtract);
	        return dp.get(key);
	    }

}

/*

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

*/