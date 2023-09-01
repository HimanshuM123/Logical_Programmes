package searching;

import java.util.HashSet;
import java.util.Set;

public class PrintRepeating {
	public static void main(String[] args) {
		int arr[] = { 3, 7, 4, 1, 4, 6, 8, 7, 8 };
		print(arr);

	}

	private static void print(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (Integer obj : arr) {
			if (!set.add(obj)) {
				System.out.print(obj + " ");
			}

		}
	}
}
