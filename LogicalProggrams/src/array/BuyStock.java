package array;

public class BuyStock {
	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		int profit =maxProfit(arr);
		System.out.println(profit);

	}

	private static int maxProfit(int[] arr) {

		int min_val = Integer.MAX_VALUE;
		int max_profit = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] < min_val) {
				min_val = arr[i];
			} else if (arr[i] - min_val > max_profit) {
				max_profit = arr[i] - min_val;
			}

		}
		return max_profit;

	}

}


/*
Maximum profit
Input [7,1,5,3,6,4]
output = 5
buy on day2 (5) sell on day5 (6) -> 6 -1=5

Input [7,6,4,3,2,1]
output : 0


*/