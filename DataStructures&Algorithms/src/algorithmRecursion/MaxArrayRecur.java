package algorithmRecursion;

public class MaxArrayRecur {
	public static void main(String[] args) {
		int arr []= {1,2,3,4};
		System.out.println("The max array is "+maxRecur(arr,0));
	}
	
	private static int maxRecur(int [] arr, int n) {
		if(n==arr.length-1) {
			return arr[n];
		}
		 
		int max2=maxRecur(arr,n+1);
		
		if(max2>arr[n]) {
			return max2;
		}else {
			return arr[n];
		}
	}
}
