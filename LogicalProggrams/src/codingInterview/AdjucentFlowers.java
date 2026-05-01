package codingInterview;
//leetcode 605
public class AdjucentFlowers {
	public static void main(String[] args) {
		int [] arr = {0,1,0,0,0,1,0,0};
		
		int t=2;
		boolean  result =canPlaceFlowers(arr,t);
		System.out.println(result);
	}
	
	
	
	private static boolean canPlaceFlowers(int[] arr, int t) {

	    int count = 0;
	    int n = arr.length;

	    for (int i = 0; i < n; i++) {

	        if (arr[i] == 0) {

	            boolean emptyLeft = (i == 0) || (arr[i - 1] == 0);
	            boolean emptyRight = (i == n - 1) || (arr[i + 1] == 0);

	            if (emptyLeft && emptyRight) {
	                arr[i] = 1;
	                count++;
	            }
	        }
	    }

	    return count >= t;
	}

}


/*

0,1,0,0,0,1,0,0
      ^       ^
	  |       |
0,1,0,1,0,1,0,1 =2	  
	  
*/