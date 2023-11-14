package matrix;

public class SearchMatrix {

	private static boolean searchInMatrix(int[][] arr, int x) {
		System.out.println(arr.length +"  "+arr[0].length);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == x) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int x = 8;
		int[][] arr = { { 0, 6, 8, 9, 11 },
						{ 20, 22, 28, 29, 31 },
						{ 36, 38, 50, 61, 63 }, 
						{ 64, 66, 100, 122, 128 } };

		boolean result = searchInMatrix(arr, x);
		if (result) {
			System.out.println("TRUE");
		} else {
			System.out.println("FALSE");
		}
	}

}
