package array;

public class BuyStock_1 {
	public static void main(String[] args) {
		int [] arr = {7,1,5,3,6,4};
		int result = getMaxProfit(arr);
		System.out.println(result);
	}

	private static int getMaxProfit(int[] arr) {
		int profit = 0;
		int min_val =Integer.MAX_VALUE;
		
		for(int i=0; i< arr.length;i++) {
			if(arr[i]<min_val) {
				min_val =arr[i];
			}
//			else if(arr[i]-min_val > profit) {
//				profit =arr[i]-min_val;
//			}
			else {
				profit =Math.max(profit, arr[i]-min_val);
				
			}
		}

		return profit;

	}

}


/*

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

*/