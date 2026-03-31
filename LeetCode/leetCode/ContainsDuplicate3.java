package leetCode;

import java.util.Arrays;

public class ContainsDuplicate3 {
	public static void main(String[] args) {
		int[] arr = { 4, -3, 8, -3, 1 };
		Arrays.sort(arr);
		ContainsDuplicate3 d =new ContainsDuplicate3();
		System.out.println(d.containsDuplicate(arr));

	}

	public boolean containsDuplicate(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if(nums[i-1]==nums[i]) {
				return true;
			}
		}
		return false;
		
	}
}
