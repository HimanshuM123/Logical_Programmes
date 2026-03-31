package sorting;

public class LinearSearch {
	public static void main(String[] args) {
		int[] numbers = { -11, -5, 0, 3, 6, 9, 18, 25, 33 };
		System.out.println(linearSearch(numbers,94));
		
	}

	public static int linearSearch(int[] array, int x) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] == x) {
				return i;
			}
		}
		return -1;

	}
}

//time complexity O(n)
