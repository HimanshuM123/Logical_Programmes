package dynamicProgramming;

public class FiboDynamic {
	static int fibo(int n) {
		return fiboRec(n, new int[n + 1]);
	}

	static int fiboRec(int n, int[] memo) {
		if (n==0 || n==1)
			return n;
		
		if (memo[n] == 0) {
			memo[n] = fiboRec(n - 1, memo) + fiboRec(n - 2, memo);
		}
		return memo[n];
	}

	public static void main(String[] args) {
		int n=6;
//		for(int i=0; i<n;i++) {
//		System.out.print(fibo(i)+" ");	
//		}
		
		System.out.print(fibo(10)+" ");	
	}
}

/*

static int fibo(int n) {
		if(n<=1) {
			return n;
		}
		return fibo(n-1)+fibo(n-2);
	}


*/