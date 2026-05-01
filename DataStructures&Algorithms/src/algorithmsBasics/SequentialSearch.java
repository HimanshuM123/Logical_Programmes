package algorithmsBasics;

public class SequentialSearch {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int searchEle = 8;

		System.out.println(seqSearch(arr, searchEle));
	}

	static int seqSearch(int[] arr, int searchEle) {
		for (int i = 0; i < arr.length; i++) {
			if (searchEle == arr[i]) {
				return i;
			}
		}
		return -1;
	}

}
