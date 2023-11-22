package array;

import java.util.HashSet;
import java.util.Set;

public class PrintDistinctEle {

	private static void printDistinctElements(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(arr[i])) {
				set.add(arr[i]);
				System.out.print(arr[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 12, 10, 9, 45, 2, 10, 10, 45 };
		printDistinctElements(arr);
	}
}
