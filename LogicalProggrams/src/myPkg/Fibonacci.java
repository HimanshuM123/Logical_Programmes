package myPkg;

public class Fibonacci {
	
	public static void main(String[] args) {
		
		// 0 1 1 2 3 5 8 13 ...
		
		int n0=0;
		int n1=1;
		int n2=0;
		int n=10;
		
		System.out.print("Fibonacci series is "+n0+" "+n1);
		
		for(int i=2;i<=n;i++) {
			n2=n0+n1;
			System.out.print(" "+n2+" ");
			n0=n1;
			n1=n2;
		}
		
	}

}
