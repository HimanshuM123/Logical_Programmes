package codingInterview;

//LeetCode 915 — Partition Array into Disjoint Intervals
public class PartitionDisjoint {
	public static void main(String[] args) {
		int[] arr = { 5, 0, 3, 8, 6 };
		int result = partitionDisjoint(arr);

		System.out.println(result);

	}

	static int partitionDisjoint(int[] arr) {
		int n = arr.length;
		int ans = 1;

		int leftMaxSoFar = arr[0];
		int maxSoFar = arr[0];
		for (int i = 1; i < n; i++) {
			maxSoFar = Math.max(maxSoFar, arr[i]);
			if (arr[i] < leftMaxSoFar) {
				ans = i + 1;
				leftMaxSoFar = maxSoFar;
			}
		}

		return ans;

	}

}


/*

5,0,3,| 8,6
right part element shud be greater than left


*/