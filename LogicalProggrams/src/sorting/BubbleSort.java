package sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
		BubbleSort bubble = new BubbleSort();
		bubble.sort(numbers);
		System.out.println(Arrays.toString((numbers)));

	}

	public void sort(int[] array) {

		for (int i = 0; i < array.length; i++)
			for (int j = 1; j < array.length - i; j++)
				if (array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}

	}

}
