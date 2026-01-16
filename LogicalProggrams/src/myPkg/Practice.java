package myPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Practice {

	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		int result = maxProfit(arr);
		System.out.println(result);
	}
	

	private static int maxProfit(int[] arr) {
		int maxProfit = 0;

		int left = 0;
		int right = 1;

		while (right < arr.length) {
			if(arr[left]< arr[right]) {
				int diff = arr[right] - arr[left];
				maxProfit = Math.max(maxProfit, diff);
				
			}else {
				left =right;
			}
			
			right++;
		}

		return maxProfit;

	}

}
