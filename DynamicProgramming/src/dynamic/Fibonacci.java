package dynamic;

public class Fibonacci {
	public static void main(String[] args) {
		//System.out.println(fibo(8));
		System.out.println(fiboMemoised(8,new int [9]));
	}
	private static int fibo(int n) {
		if(n==0 || n==1)
			return n;
		System.out.println("Hello "+n);
		int fib1=fibo(n-1);
		int fib2=fibo(n-2);
		int fib=fib1+fib2;
		return fib;
	}
	
	private static int fiboMemoised(int n, int [] arr) {
		if(n==0 || n==1) {
			return n;
		}
		if(arr[n]!=0) {
			return arr[n];
		}
		
		System.out.println("Hello "+n);
		int fib1=fiboMemoised(n-1,arr);
		int fib2=fiboMemoised(n-2,arr);
		int fib=fib1+fib2;
		arr[n]=fib;
		return fib;
	}
	
	

}

// 0 1 1 2 3 5 8 13 21