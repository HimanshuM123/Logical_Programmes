package algorithmsBasics;

public class SumOfElements {
	public static void main(String[] args) {
			int arr[]= {2,5,8,1,4,7,9,13};
			int sum=10;
			
			for(int i=0;i<arr.length;i++) {
				for(int j=i+1;j<arr.length;j++) {
					if(arr[i]+arr[j]==sum) {
						System.out.println("The elements are "+ arr[i]+" "+arr[j]);
					}
				}
			}
	}
}
