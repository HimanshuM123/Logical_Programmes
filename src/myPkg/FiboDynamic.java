package myPkg;

public class FiboDynamic {
	static int fibo(int n) {
		return fiboRec(n, new int[n + 1]);
	}

	static int fiboRec(int n, int[] memo) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (memo[n] == 0) {
			memo[n] = fiboRec(n - 1, memo) + fiboRec(n - 2, memo);
		}
		return memo[n];
	}

	public static void main(String[] args) {
		int n=6;
		for(int i=0; i<n;i++) {
		System.out.print(fibo(i)+" ");	
		}
	}
}
