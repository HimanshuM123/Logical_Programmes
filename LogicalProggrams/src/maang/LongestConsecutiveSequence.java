package maang;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	
	public static void main(String[] args) {
	int[]	nums = {100,4,200,1,3,2};
	
	int result  = longestConsecutiveSequence(nums);
	System.out.println(result);
	
	}
	
	
	private static int longestConsecutiveSequence(int [] nums) {
		
		int Max_Len = Integer.MIN_VALUE;
		
		Set<Integer> set = new HashSet<>();
		for(int obj : nums) {
			set.add(obj);
		}
		
		for(int obj : nums) {
			int count =0;
			while(set.contains(obj++)) {
				count = count+1;
			}
			
			Max_Len = Math.max(count, Max_Len);
			
		}
		
		
		
		return Max_Len;
	}
	

}
