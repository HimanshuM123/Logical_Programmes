package practice;

import java.util.Arrays;

public class ReverseArray {
	public static void main(String[] args) {
		char[] arr = { 'h', 'e', 'l', 'l', 'o' };
		char [] result =rev(arr);
		System.out.print(Arrays.toString(result));
		

	}

	public static char[] rev(char[] arr) {

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {

			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;

		}

		return arr;
	}

}
