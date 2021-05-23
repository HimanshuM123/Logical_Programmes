package algorithmsBasics;

public class SecondLargeElement {
	public static void main(String[] args) {
		int arr[]= {4,3,8,5,2,6,9};
		
		int secondLarge=secondLargeElement(arr);
		System.out.println(secondLarge);
		
		
	}
	
	private static int secondLargeElement(int [] arr) {
		int maxOne=arr[0];
		int maxTwo=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>maxOne) {
				maxTwo=maxOne;
				maxOne=arr[i];
			}
			
		}
		return maxTwo;
	}

}
