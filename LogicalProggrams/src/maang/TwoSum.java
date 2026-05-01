package maang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args) {
	int []	nums = {2, 7, 11, 15};
	int  target = 9;
	
	int [] result = twoSum(nums,target);
	
	System.out.println(Arrays.toString(result));
	
	}
	
	
	private static int [] twoSum(int [] nums, int target) {
		
		Map<Integer,Integer> hm = new HashMap<>();
		int [] result= new int[2];
		
		for(int i=0; i<nums.length;i++) {
			
			int key = target-nums[i];
			
			if(hm.get(nums[i])==null) {
				hm.put(key, i);
				
			}else {
				result[0]=i;
				result[1]=hm.get(nums[i]);
				
			}
			
			
			
		}
		
		return result;
	}

}
