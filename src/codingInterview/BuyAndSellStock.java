package codingInterview;

public class BuyAndSellStock {
	
	public static void main(String[] args) {
		
		int [] arr = {7,1,5,3,6,4};
		
		int profit = getProfit(arr);
		
		System.out.println("The total ptofit is "+profit);
		
		
	}
	
	//Greedy approach 
	private static int getProfit(int[] arr) {
		int profit = 0;
		for (int i = 1; i < arr.length; i++) {

			if (arr[i] - arr[i - 1] > 0) {
				profit = profit + arr[i] - arr[i - 1];
			}
		}
		return profit;
	}
	

}
