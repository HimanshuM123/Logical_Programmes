package algorithmsBasics;

import java.util.Arrays;

public class ArrayRotate {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		// [30,40,50,60,10,20]
          int n=2;
		for (int i = 0; i < n; i++) {
			int temp = arr[0];
			for (int j = 0; j < arr.length; j++) {
				if (j != arr.length-1) {
					arr[j] = arr[j + 1];
				} else {
					arr[j] = temp;
				}
			}

		}
		System.out.println(Arrays.toString(arr));
	}
}
