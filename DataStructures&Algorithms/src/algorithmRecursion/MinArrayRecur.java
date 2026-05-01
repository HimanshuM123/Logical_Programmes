package algorithmRecursion;

public class MinArrayRecur {
	
	public static void main(String[] args) {
		int arr[]= {9,3,-7,2};
		System.out.println(minArrayRecur(arr,0));
	}
	
	
	private static int minArrayRecur(int[] arr,int n) {
		
		if(n==arr.length-1) {
			return arr[n];
		}
		
		int min=minArrayRecur(arr,n+1);
		
		if(arr[n]<min) {
			return arr[n];
		}else {
			return min;
		}
		
	}

}
