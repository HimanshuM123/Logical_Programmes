package maang;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
	public static void main(String[] args) {
		int [] nums = {4,3,2,7,8,2,3,1};
		
		List<Integer> result = findDuplicates(nums);
		System.out.println(result);
				
	}
	
	
	public static List<Integer> findDuplicates(int[] nums) {
		
		List<Integer> result = new ArrayList<>();
		
		for(int num:nums) {
			int idx= Math.abs(num)-1;
			if(nums[idx]<0) {
				result.add(idx+1);
			}else {
				 nums[idx] = -nums[idx];
			}
		}
		return result;
		
		
	}

}

//[2, 3]

