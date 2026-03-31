package myPkg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates2 {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 1, 3 };

		Set<Integer> set = new LinkedHashSet<>();

		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		int result[] = new int[set.size()];
		int j = 0;
		for (Integer o : set) {
			result[j] = o;
			j++;
		}
		
		System.out.println(Arrays.toString(result));
	}

}
