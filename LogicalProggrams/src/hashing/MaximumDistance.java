package hashing;

import java.util.HashMap;
import java.util.Map;

public class MaximumDistance {
	
	private static int maxDist(int[] arr) {
		int max_dist = 0;
		Map<Integer, Integer> hm = new HashMap<>();
//map -> <Element, Position>
		for (int i = 0; i < arr.length; i++) {
			if (hm.get(arr[i]) == null) {
				hm.put(arr[i], i);
			} else {
				max_dist = Math.max(max_dist, i - hm.get(arr[i]));
			}
		}
		return max_dist;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2 };
		int result = maxDist(arr);
		System.out.println("The maximum distance is "+result);
	}

}

//output -> The maximum distance is 10


/*

Input : arr[] = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2}
Output: 10
// maximum distance for 2 is 11-1 = 10 
// maximum distance for 1 is 4-2 = 2 
// maximum distance for 4 is 10-5 = 5 


*/