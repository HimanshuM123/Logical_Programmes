package sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
		SelectionSort selection = new SelectionSort();
		selection.selectionSort(numbers);
		System.out.println(Arrays.toString((numbers)));
	}

	public void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++)
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}

	}

}
//complexity O(n^2)
