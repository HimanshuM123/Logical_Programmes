package algorithmRecursion;

import java.util.ArrayList;
import java.util.List;

public class FindIndexes {
	public static void main(String[] args) {
		int[] arr = { 1, 7, 3, 5, 6, 7, 8 };
		int target = 7;
		List<Integer> list = new ArrayList<>();
		List<Integer> result = findAllIndex(arr,target,0,list);
		System.out.println(result);
		
	}

	private static List<Integer> findAllIndex(int[] arr, int target, int index, List<Integer> list) {
		if (index == arr.length - 1) {
			return list;
		}
		if (arr[index] == target) {
			list.add(index);
		}

		return findAllIndex(arr, target, index + 1, list);
	}

}
