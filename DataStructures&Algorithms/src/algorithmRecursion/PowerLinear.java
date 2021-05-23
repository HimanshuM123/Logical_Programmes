package algorithmRecursion;

public class PowerLinear {
	public static void main(String[] args) {
		
		System.out.println(powerLinear(2,4));
		
	}
	
	static int powerLinear(int x,int n) {
		if(n==0) {
			return 1;
		}
		return x*powerLinear(x,n-1);
		
	}

}


//x^n= x*x*x*x...n times
