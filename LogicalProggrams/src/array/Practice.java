package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Practice {
	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		int result = maxProfit(arr);
		System.out.println(result);
	}

	public static int maxProfit(int[] prices) {
		int left = 0;
		int right = 1;
		int maxP = 0;

		while (right < prices.length) {
			if (prices[left] < prices[right]) {
				int profit = prices[right] - prices[left];
				maxP = Math.max(maxP, profit);

			} else {
				left = right;
			}

			right++;
		}

		return maxP;

	}

}
