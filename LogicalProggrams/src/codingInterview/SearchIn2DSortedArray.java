package codingInterview;

public class SearchIn2DSortedArray {
	public static void main(String[] args) {
		int[] [] matrix = {
				 {1, 4, 7, 11},
		         {2, 5, 8, 12},
		         {3, 6, 9, 16},
		         {10, 13, 14, 17}
		};
		int target =5;
		boolean result = searchMatrix(matrix,target);
		System.out.println("Result "+result);
	}
	
	
	private static boolean searchMatrix(int[] [] matrix , int target) {
		
		if(matrix==null || matrix.length==0 || matrix[0].length==0) {
			return false;
		}
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int r=0;
        int c = cols - 1; // start at top-right corner

		while(r <rows && c>=0) {
			if(matrix[r][c]==target) {
				return true;
			}else if(matrix[r][c] >target) {
				c--;
			}
			else {
				r++;
			}
			
		}
		
		
		
		
		
		return false;
		
	}

}
