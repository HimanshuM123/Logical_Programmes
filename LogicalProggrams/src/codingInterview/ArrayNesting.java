package codingInterview;

//LeetCode 565
public class ArrayNesting {

	public static void main(String[] args) {
		int[] arr = { 5, 4, 0, 3, 1, 6, 2 };
		int result = arrayNesting(arr);

		System.out.println(result);

	}

	public static int arrayNesting(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		int maxLen = 0;

		for (int i = 0; i < nums.length; i++) {

			int count = 0;
			int current = i;

			while (!visited[current]) {
				visited[current] = true;
				current = nums[current];
				count++;
			}
			maxLen = Math.max(maxLen, count);
		}

		return maxLen;
	}

}



/*

51/200

For:

[5,4,0,3,1,6,2]

Start at i = 0:

0 → 5 → 6 → 2 → back to 0
count = 4

Mark all visited → skip them later

*/
