package codingInterview;

public class EquilibriumIndex {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 2, 2 };

		int index = equilibriumIndex(arr);
		System.out.println("equilibriumIndex " + index); //equilibriumIndex 2

	}

	private static int equilibriumIndex(int[] arr) {

		int totalSum = 0;
		for (int num : arr) {
			totalSum = totalSum + num;
		}

		int leftSum = 0;
		for (int i = 0; i < arr.length; i++) {
			int rightSum = totalSum - leftSum - arr[i];
			if (leftSum == rightSum) {
				return i;
			}

			leftSum = leftSum + arr[i];
		}

		return -1;

	}

}



/*

Input:
       ~
[1, 3, 5, 2, 2]

At index 2:

Left sum = 1 + 3 = 4
Right sum = 2 + 2 = 4



*/