package matrix;

public class PrintDiagonal {
	private static void printPrincipalDiagonal(int arr[][]) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i == j) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}
	}

	private static void printSecondaryDiagonal(int arr[][]) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i + j == length - 1) {
					System.out.print(arr[i][j] + "  ");
				}
			}
		}
	}
	
	public static void main(String[] args) {
	
		    int arr[][] = { { 1, 2, 3, 4 }, 
		                 	{ 5, 6, 7, 8 }, 
		                 	{ 1, 2, 3, 4 }, 
		                 	{ 5, 6, 7, 8 } 
		                }; 
		    System.out.println("Primary diagonal");
		    printPrincipalDiagonal(arr);
		    System.out.println();
		    System.out.println("Secondary diagonal");
		    printSecondaryDiagonal(arr);
		    
	}
}
