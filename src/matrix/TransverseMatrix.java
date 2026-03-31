package matrix;


public class TransverseMatrix {
	
	private static int M=3;
	private static int N=3;
	
	private static void trasverse(int arr [] [] , int i, int j) {
		if(i==N-1 && j==M-1) {
			System.out.println(arr[i][j]);
			return;
		}
		System.out.print(arr[i][j]+" ");
		
		if(j< M-1) {
			trasverse(arr,i,j+1);
		}
		else if(i< N-1) {
			trasverse(arr,i+1,0);
		}
		
		
		
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		trasverse(arr,0,0);
	}

}
