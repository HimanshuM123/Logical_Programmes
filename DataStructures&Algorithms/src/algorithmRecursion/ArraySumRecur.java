package algorithmRecursion;

public class ArraySumRecur {
	public static void main(String[] args) {
		int arr[]= {1,2,3,4};
		System.out.println(sumRecur(arr,0));
	}
	
	private static int sumRecur(int arr[],int n) {
		if(n==arr.length-1) {
			return arr[n];
		}
		
		int sum=sumRecur(arr,n+1);
		sum=sum+arr[n];
		return sum;
	}

}
