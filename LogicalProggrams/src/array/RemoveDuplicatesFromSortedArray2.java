package array;

public class RemoveDuplicatesFromSortedArray2 {

	public static void main(String[] args) {
		int[] array = { 1, 1, 2, 2, 3, 4, 5, 5, 5 };

		int length = removeDuplicates(array);
		System.out.println("Length after removing duplicates: " + length);
	}

	private static int removeDuplicates(int[] array) {
		int index = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] != array[i]) {
				index++;
			}
		}
		return index;

	}

}
