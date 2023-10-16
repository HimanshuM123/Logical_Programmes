package array;

public class MiddleElement {
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7};
		
		int left =0;
		int right = arr.length-1;
		
		while(left <= right) {
			if(left == right) {
				System.out.println("Middle ele is = "+arr[left]);
				break;
			}
			left++;
			right--;
		}
	}
}
