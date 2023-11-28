package algorithmRecursion;

public class LinearSearch {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 6, 7, 8 };
		int target = 4;
		boolean result = find(arr, target, 0);
		if(result) {
			System.out.println("The target found");
		}else {
			System.out.println("The target NOT found");
		}
	}

	private static boolean find(int[] arr, int target, int index) {
		if (index == arr.length - 1) {
			return false;
		}
		return arr[index] == target || find(arr, target, index + 1);

	}

}
