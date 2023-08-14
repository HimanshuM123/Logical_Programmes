package myPkg;

public class FiboRecur {
	
	
	static int fibo(int n) {
	    if (n == 0) return 0;
	    if (n == 1) return 1;
	    return fibo(n-1) + fibo(n-2);
	}
	
public static void main(String[] args) {
	int n=6;
	for(int i=0; i<n;i++) {
	System.out.print(fibo(i)+" ");	
	}
	
}
}


//0 1 1 2 3 5 8 13 21 34