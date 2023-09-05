package searching;

import java.util.Arrays;

public class FindPair {

	public static void main(String[] args) {
		int[] arr = { 4, 6, 8, 9, 1, 2, 3, 5 };
		int sum = 17;
		int [] result=findPair(arr,sum); 
		System.out.println("The result is "+Arrays.toString(result));

	}

	private static int[] findPair(int[] arr, int sum) {

		int[] result = new int[2];
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					result[0] = arr[i];
					result[1] = arr[j];
					return result;
				}
			}
		}
		return result;
	}

}


//complexity = > O(n2)