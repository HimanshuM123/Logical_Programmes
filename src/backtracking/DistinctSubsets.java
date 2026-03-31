
package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class DistinctSubsets {
	public static void findSubsets(int ind, int[] nums, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ansList) {
		ansList.add(new ArrayList<>(ds));
		for (int i = ind; i < nums.length; i++) {
			if (i != ind && nums[i] == nums[i - 1])
				continue;

			ds.add(nums[i]);
			findSubsets(i + 1, nums, ds, ansList);
			ds.remove(ds.size() - 1);
		}
	}

	private static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {
		// your code here
		Arrays.sort(arr);
		ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
		findSubsets(0, arr, new ArrayList<>(), ansList);

		return ansList;
	}

	public static void main(String[] args) {
		int[] set = { 10, 12, 12 };
		System.out.println(AllSubsets(set, 3));
	}
}

/*

Input:  S = {1, 2, 2}
Output:  {}, {1}, {2}, {1, 2}, {2, 2}, {1, 2, 2}
Explanation: The total subsets of given set are – {}, {1}, {2}, {2}, {1, 2}, {1, 2}, {2, 2}, {1, 2, 2}


*/