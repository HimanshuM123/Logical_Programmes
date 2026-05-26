package maang;

public class BuySellStock2 {

	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };

		int profit = maximumProfit(arr);
		System.out.println(profit);
	}

	private static int maximumProfit(int[] arr) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int obj : arr) {
			minPrice = Math.min(minPrice, obj);

			maxProfit = Math.max(maxProfit, obj - minPrice);

		}

		return maxProfit;

	}

}
