package array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallerNumbersThanCurrent2 {

	public static void main(String[] args) {
		int[] nums = { 8, 1, 2, 2, 3 };
		
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
		

	}

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] result = new int[nums.length];
		int count=0;

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(Integer i : nums) {
			queue.add(i);
		}
		
		for(int i=0;i< nums.length;i++) {
			
		}
		return result;

	}

}
//[4, 0, 1, 1, 3]

