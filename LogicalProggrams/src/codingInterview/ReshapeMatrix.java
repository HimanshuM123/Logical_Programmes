package codingInterview;

public class ReshapeMatrix {
	
	public static void main(String[] args) {
		
		int[][] mat = {
			    {1, 2},
			    {3, 4}
			};
			int r = 1;
			int c = 4;
			
			int[][] res =matrixReshape(mat,r,c);
			System.out.println(res);
			
			
	}
	
	private static int[][] matrixReshape(int[][] mat, int r, int c) {
		int rows = mat.length;
		int cols = mat[0].length;
		
		if(rows*cols!= r*c) {
			return mat;
		}
		
		 int[][] reshaped = new int[r][c];
	        int row = 0, col = 0;
	        
	        for(int i=0; i<rows;i++) {
	        	for(int j=0; j<cols;j++) {
	        		reshaped[row][col]=mat[i][j];
	        		col++;
	                // When the column index reaches c, reset it and move to the next row
	                if (col == c) {
	                    col = 0;
	                    row++;
	                }

	        		
	        	}
	        }
	        return reshaped;
		
	}

}
