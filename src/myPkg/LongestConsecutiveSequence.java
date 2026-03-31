package myPkg;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int arr[] = { 4, 3, 2, 1, 100, 101 };
		int max = 1;

		Set<Integer> set = new HashSet<>();
		for (Integer obj : arr) {
			set.add(obj);
		}

		for (Integer obj : arr) {
			int left = obj - 1;
			int right = obj + 1;
			int count = 1;

			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}
			max= Math.max(count, max);
		}
		System.out.println("The result is "+max);
	}
	
	

}

// For example, given [100, 4, 200, 1, 3, 2], the longest consecutive elements sequence
//should be [1, 2, 3, 4]. Its length is 4.