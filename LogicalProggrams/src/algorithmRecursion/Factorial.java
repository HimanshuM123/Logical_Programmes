package algorithmRecursion;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(fact(5));
	}
	
	public  static int fact(int n) {
		if (n<=1) { //<- termination condition
			return 1;
		}
		else {
			int result = n*fact(n-1);
			return result;
		}
	}

}
