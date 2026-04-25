package maang;

/*
 * prices = [7,1,5,3,6,4]
 * Buy at 1
Sell at 6
Profit = 5
 */
public class BuySellStock {

	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };

		int profit = maximumProfit2(arr);
		System.out.println(profit);
	}

	private static int maximumProfit(int[] arr) {

		int profit = 0;
		int min = Integer.MAX_VALUE;

		for (int obj : arr) {
			min = Math.min(min, obj);
			profit = Math.max(profit, obj - min);

		}
		return profit;
	}
	
	
	private static int maximumProfit2(int[] arr) {
		int profit = 0;
		int l = 0;
		int r = 1;
		while (r < arr.length) {
			if (arr[l] < arr[r]) {
				profit = Math.max(arr[r] - arr[l], profit);

			} else {
				l = r;
			}
			r++;

		}

		return profit;

	}
	
	

}
