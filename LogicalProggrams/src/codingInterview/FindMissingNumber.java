package codingInterview;

public class FindMissingNumber {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 4, 5 };
		int N = 5;
		int result1 = findMissing1(arr, N);
		System.out.println(result1);
		
		int result2 = findMissing2(arr, N);
		System.out.println(result2);

	}

	private static int findMissing1(int[] arr, int N) {
		int sum = 0;
		for (int obj : arr) {
			sum = sum + obj;
		}

		int gaussSum = N * (N + 1) / 2;
		return gaussSum - sum;

	}
	
	private static int findMissing2(int[] arr, int N) {
		//1^3^4^5  ^1^2^3^4^5
		
		int xor1= 0;
		int xor2=0;
		
		for(int obj:arr) {
			xor1 =xor1^obj;
		}
		
		for(int i=1;i<N+1;i++) {
			xor2=xor2^i;
		}
		
		return xor1^xor2;
		

	}

}
