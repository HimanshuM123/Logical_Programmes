/*
 * LeetCode 121: Best Time to Buy and Sell Stock
 *
 * Problem: Given an array prices where prices[i] is the price on day i,
 * return the maximum profit you can achieve. You can buy once and sell once.
 * If no profit possible, return 0.
 *
 * Example: Input: prices = [7,1,5,3,6,4] -> Output: 5 (buy at 1, sell at 6)
 *
 * Approach: Single Pass with Min Tracking
 * - Track minimum price seen so far
 * - For each price, calculate profit if sold at that price
 * - Keep track of maximum profit
 *
 * Time Complexity: O(n) - single pass
 * Space Complexity: O(1) - only a few variables
 */

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Profit if selling at current price
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);

            // Update minimum price if current is lower
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();

        System.out.println(sol.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));  // 5
        System.out.println(sol.maxProfit(new int[]{7, 6, 4, 3, 1}));     // 0
        System.out.println(sol.maxProfit(new int[]{2, 4, 1, 7, 5, 11})); // 10
        System.out.println(sol.maxProfit(new int[]{1}));                 // 0
    }
}
