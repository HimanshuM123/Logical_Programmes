package codingInterview;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
	
	public static void main(String[] args) {
		int [] nums = {1,1,1,3,3,2,2,2};
		List<Integer> result = majorityElement(nums);
		System.out.println(result);
	}
	
	
	private static List<Integer> majorityElement(int [] nums) {
		List<Integer> list = new ArrayList<>();
		if(nums==null || nums.length==0) {
			return list;
		}
		
		int candidate1=0, candidate2=0;
		int count1=0, count2=0;
		
		//First Pass
		for(int num : nums) {
			if(num==candidate1) {
				count1++;
			}else if (num ==candidate2) {
				count2++;
			}else if(count1==0) {
				candidate1=num;
				count1=1;
			}else if(count2==0) {
				candidate2=num;
				count2=1;
			}
		 else {
            count1--;
            count2--;
          }	
		}
		
		  // Second pass: verify counts
		count1=0;
		count2=0;
		
		for(int num:nums) {
			if(num ==candidate1) {
				count1++;
			}else if(num ==candidate2) {
				count2++;
			}
		}
		
		int n= nums.length;
		if(count1> n/3) {
			list.add(candidate1);
		}if(count2> n/3) {
			list.add(candidate2);
		}
		
		
		return list;
	}

}


/*

Given an integer array nums, return all elements that appear more than ⌊n / 3⌋ times, where n is the size of the array.


Input: nums = [1,1,1,3,3,2,2,2]
Output: [1,2]

*/