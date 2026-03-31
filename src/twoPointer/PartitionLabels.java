package twoPointer;

import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {
	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		List<Integer> result = partitionLabels(s);
		System.out.println(result);
	}

	private static List<Integer> partitionLabels(String s) {

		char[] arr = s.toCharArray();
		int[] cache = new int[128];
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			char curr = arr[i];
			cache[curr] = i;
		}

		int left = 0;
		int right = 0;
		int index = 0;

		while (index < arr.length) {
			char curr = arr[index];
			right = Math.max(right, cache[curr]);
			if (right == index) {
				int size = right - left + 1;
				list.add(size);
				right++;
				left = right;
			}

			index++;
		}

		return list;
	}
}

/*
 * 
 * S ="ababcbacadefegdehijhklij";
 * 
 * ababcbaca defegde hijhklij 
 * [9, 7, 8]

 * 
 */