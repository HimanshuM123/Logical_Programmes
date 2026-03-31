package slidingWindow;

public class MaximumSumOfSubArray {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
		int k = 4;

		getMaxSum(arr, k);

	}

	private static int getMaxSum(int[] arr, int k) {
		int max_sum = Integer.MIN_VALUE;
		int window_sum = 0;

		for (int i = 0; i < k; i++) {
			window_sum = window_sum + arr[i];
		}
		// System.out.println(window_sum);
		max_sum = window_sum;

		for (int i = k; i < arr.length; i++) {
			window_sum = window_sum + arr[i] - arr[i - k];
			max_sum = Math.max(max_sum, window_sum);
		}

		System.out.println(max_sum);

		return 0;
	}
}

/*
 * arr = 1,4,2,10,23,3,1,0,20 k =4 output =39
 * 
 * step1 : (1,4,2,10),23,3,1,0,20 sum =17
 * 
 * step2 : 1,(4,2,10,23),3,1,0,20 sum =17+(-1)+23=39 = Max number
 * 
 * step3 : 1,4,(2,10,23,3),1,0,20 sum =39+(-4)+3=38
 * 
 * step4 : 1,4,2,(10,23,3,1),0,20 sum =38+(-2)+1=37
 * 
 * step5 : 1,4,2,10,(23,3,1,0),20 sum =37+(-10)+0=27
 * 
 * step6 : 1,4,2,10,23,(3,1,0,20) sum =27+(-23)+20=24
 * 
 */
