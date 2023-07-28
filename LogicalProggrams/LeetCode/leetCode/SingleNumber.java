package leetCode;
//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.
//Input: nums = [4,1,2,1,2]
//Output: 4

public class SingleNumber {
public static void main(String[] args) {
	
	int [] arr= {1,2,1,2,3};
	SingleNumber s = new SingleNumber();
	
	System.out.println("Result is "+s.singleNumber(arr));
	
	
}
public int singleNumber(int[] nums) {
	int result=0;
	boolean flag = false;
	
		for(int i=0 ;i<nums.length;i++) {
			for(int j=0 ;j<nums.length;j++) {
				if(i==j) {
					continue;
				}if(nums[i]==nums[j]) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				result = nums[i];
			}
			flag=false;
	}
	return result;
}   
}

