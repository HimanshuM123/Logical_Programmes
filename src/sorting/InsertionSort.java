package sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] numbers = { 4,3,2,1 };
		InsertionSort insertion = new InsertionSort();
		insertion.sort(numbers);
		System.out.println(Arrays.toString((numbers)));
	}

	public void sort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int current = array[i];
			int j=i-1;
			while(j>=0 && array[j]>current) {
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=current;
		}

	}
	//time complexity
	//O(n) best case
	//O(n2) worst case

}
