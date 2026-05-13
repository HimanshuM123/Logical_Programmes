package codingInterview;

public class EquivalentDominoPairs {

	public static void main(String[] args) {

		int[][] dominoes = { { 1, 2 }, { 1, 2 }, { 2, 1 }, { 3, 4 } };
	//	int[][] dominoes = { { 1, 2 }, { 1, 2 }, { 2, 1 }, { 1,2 } };
		int count[] = new int[100];
		int result = 0;

		for (int[] d : dominoes) {
			int a = d[0];
			int b = d[1];

			int key = Math.min(a, b) * 10 + Math.max(a, b);

			result = result + count[key];
			count[key]++;

		}
		System.out.println(result);//3 -> 
	}

}


/*

Two dominoes are considered the same if:

[a, b] == [c, d]  OR  [a, b] == [d, c]

👉 Order does NOT matter

Examples:
[1,2] == [2,1] ✅
[3,4] == [3,4] ✅
[1,2] != [3,1] ❌



*/