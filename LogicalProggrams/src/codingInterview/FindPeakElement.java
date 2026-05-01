package codingInterview;

public class FindPeakElement {
	
	private static int findPeakElement(int [] nums) {
		
		int left =0; int right =nums.length-1;
		
		while(left<right) {
			int mid = left +(right-left)/2;
			if(nums[mid]>nums[mid+1]) {
				
				// descending → peak is on left side
                right = mid;
            } else {
                // ascending → peak is on right side
                left = mid + 1;
            }
			
		}
		return left;
	}
	
	public static void main(String[] args) {
		// int[] nums = {1, 2, 3, 1}; // Output: 2
		 int[] nums = {1, 2, 1, 3, 5, 6, 4};
	        System.out.println(findPeakElement(nums)); 
	}

}


/*
Given an integer array nums, find a peak element, and return its index.

A peak element is an element that is strictly greater than its neighbors.

📌 Definition
nums[i] is a peak if:
nums[i] > nums[i-1] AND nums[i] > nums[i+1]

Example 1
Input: nums = [1, 2, 3, 1]
Output: 2

Explanation:

3 is greater than 2 and 1 → peak
🧪 Example 2
Input: nums = [1, 2, 1, 3, 5, 6, 4]
Output: 1 or 5
*/