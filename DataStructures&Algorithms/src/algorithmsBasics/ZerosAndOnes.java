package algorithmsBasics;

import java.util.Arrays;

public class ZerosAndOnes {
	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0 };
		int temp = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 1 && count < arr.length - 1) {
				temp = arr[i];

				int j = i;
				while (j < arr.length - 1) {
					arr[j] = arr[j + 1];
					j++;

				}
				arr[arr.length - 1] = temp;
				i--;
				count++;

			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
