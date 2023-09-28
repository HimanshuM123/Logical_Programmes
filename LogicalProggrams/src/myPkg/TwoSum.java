package myPkg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int arr[] = { 11, 15, 2, 7 };
		int target = 9;
		TwoSum sum = new TwoSum();

		int[] restlt = sum.getIndex(arr, target);
		System.out.println(Arrays.toString(restlt));

	}

	private int[] getIndex(int arr[], int target) {
		Map<Integer, Integer> hm = new HashMap<>();
		int[] result = new int[2];
		for (int i = 0; i < arr.length; i++) {
			if (hm.containsKey(arr[i])) {
				result[0] = i;
				result[1] = hm.get(arr[i]);
			} else {
				hm.put(target - arr[i], i);
			}
		}
		return result;
	}

}

//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2