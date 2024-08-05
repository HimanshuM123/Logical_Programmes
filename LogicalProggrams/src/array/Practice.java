package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Practice {
	public static void main(String[] args) {

		// int [] arr = {1,2,3};
		int[] arr = { 1, 2, 9 };
		// int [] arr = {9,9,9};
		// int [] arr = {1,9,9};
		System.out.println(Arrays.toString(pluseOne(arr)));

	}

	private static int[] pluseOne(int[] arr) {

		int length = arr.length;

		for (int i = length - 1; i > 0; i--) {
			if(arr[i]<9) {
				arr[i]++;
				return arr;
			}
			arr[i]=0;
		}
		
		return new int[3];

	}

}
