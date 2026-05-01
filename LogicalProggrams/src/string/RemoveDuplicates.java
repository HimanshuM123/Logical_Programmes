package string;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String str = "aghsttth  agshahha";

		char[] arr = str.replace(" ", "").toCharArray();

		Arrays.sort(arr);
		System.out.println(arr);

		int left = 0;
		int right = 1;
		String result = "";

		while (right < arr.length) {
			if (arr[left] != arr[right]) {
				result = result + arr[left];
				left = right;
			}

			right++;
		}
		result = result + arr[left];

		System.out.println(result);

	}

}
