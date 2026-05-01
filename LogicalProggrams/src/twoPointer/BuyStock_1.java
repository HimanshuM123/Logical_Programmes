package twoPointer;

public class BuyStock_1 {
	public static void main(String[] args) {
		int [] arr = {7,1,5,3,6,4};
		int result = maxProfit(arr);
		System.out.println(result);
	}

	
	    public static int maxProfit(int[] prices) {
	        int l = 0, r = 1;  // l is the left pointer (buy), r is the right pointer (sell)
	        int maxP = 0;
	        
	        while (r < prices.length) {
	            if (prices[l] < prices[r]) {
	                int profit = prices[r] - prices[l];
	                maxP = Math.max(maxP, profit);
	            } else {
	                l = r;  // Move the left pointer to the right
	            }
	            r++;
	        }
	        
	        return maxP;
	    }
	}




/*

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

*/