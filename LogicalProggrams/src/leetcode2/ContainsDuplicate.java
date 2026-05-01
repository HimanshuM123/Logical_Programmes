package leetcode2;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public static void main(String[] args) {
		int arr [] = {1,2,3,4};
		boolean flag = false;
		Set<Integer> hs = new HashSet<>();
		for(int i=0;i<arr.length;i++) {
			 flag =!hs.add(arr[i]);
		}
		if(flag) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
}
//1,2,3,1 -> true
//1,2,3,4 -> false