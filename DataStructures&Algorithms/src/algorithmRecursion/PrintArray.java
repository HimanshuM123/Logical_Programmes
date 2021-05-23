package algorithmRecursion;

public class PrintArray {
	public static void main(String[] args) {
		int arr[]= {10,20,30,40,50};
		displayArr( arr, 4);
	}
	
	private static void displayArr(int [] arr,int idx) {
		if(idx==-1) {
			return;
		}
		displayArr( arr, idx-1);
		System.out.println(arr[idx]);
	}

}
