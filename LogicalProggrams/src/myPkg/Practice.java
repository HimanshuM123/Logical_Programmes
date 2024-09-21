package myPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Practice {

	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		int result = maxProfit(arr);
		System.out.println(result);

	}

	private static int maxProfit(int[] arr) {
		int profit = 0;
		int left = 0;
		int right = 1;

		while (right < arr.length) {

			if (arr[left] < arr[right]) {

				int diff = arr[right] - arr[left];
				profit = Math.max(profit, diff);
			

			} else {
				left = right;
			}

			right++;
		}

		return profit;

	}

}

/*
 * 
 * j=0 a=1 v=2 a=3
 * 
 * 
 * 
 * 
 */
