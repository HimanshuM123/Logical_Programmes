package array;

import java.util.HashMap;
import java.util.Map;

public class EqualizeArray {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 3 };
		int result = deletions(arr);
		System.out.println(result);

	}

	private static int deletions(int arr[]) {
		int deletions = 0;
		Map<Integer, Integer> hm = new HashMap<>();

		for (Integer obj : arr) {
			if (hm.get(obj) == null) {
				hm.put(obj, 1);
			} else {

				hm.put(obj, hm.get(obj) + 1);
			}

		}
		
		for(Map.Entry<Integer, Integer> obj : hm.entrySet()) {
			if(obj.getValue()==1) {
				deletions++;
			}
		}
		return deletions;

	}

}

/*
 * 
 * Given an array of integers, determine the minimum number of elements to
 * delete to leave only elements of equal value. arr =[1,2,2,3] 1,3 => 2
 * deletions required
 */