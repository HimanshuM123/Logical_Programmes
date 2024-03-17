package array;

public class CheckForSorted {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50, 30 };
		boolean flag = isSoretd(arr);
		if(flag) {
			System.out.println("The array is sorted");
		}else {
			System.out.println("The array is NOT sorted");
		}
		

	}

	private static boolean isSoretd(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			if (arr[i-1] > arr[i ]) {
				return false;
			}
		}
		return true;
	}
}
