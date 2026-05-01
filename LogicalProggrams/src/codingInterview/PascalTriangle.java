package codingInterview;

public class PascalTriangle {
	public static void main(String[] args) {
        int rows=5;
        for(int N=0;N<rows;N++) {
        	int x=1;
        	for(int R=0;R<=N;R++) {
        		System.out.print(x+" ");
        		x=x*(N-R)/(R+1);
        	}
        	System.out.println();
        }
        		
	}
}


/*

1
1 1
1 2 1
1 3 3 1
1 4 6 4 1 

*/