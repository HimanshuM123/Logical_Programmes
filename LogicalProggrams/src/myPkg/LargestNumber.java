package myPkg;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String leftRight = s1 + s2;
				String rightLeft = s2 + s1;
				int i =-leftRight.compareTo(rightLeft);
				System.out.println("i "+i);
				return i;
			}
		});
		
		
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s);
		}
		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		
		
		//int x = -"21677".compareTo("17762");
		
		LargestNumber obj = new LargestNumber();
		int[] arr = { 5,7,1 };
	//	int[] arr = { 1,2,3,4,5 };
		String result = obj.largestNumber(arr);
		System.out.println(result);
	}
}

//[3, 30, 34, 5, 9], the largest formed number is 9534330