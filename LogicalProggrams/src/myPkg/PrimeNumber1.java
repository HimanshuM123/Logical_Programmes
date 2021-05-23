package myPkg;

public class PrimeNumber1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int num=209;
		boolean isPrime=true;
		int divisibleBy=0;
		
		for (int i=2;i<num;i++) {
			if(num%i==0) {
				isPrime=false;
				divisibleBy=i;
				break;
			}
		}
		
		if(isPrime==true) {
			System.out.println("The number is prime ");
		}
		else {
			System.out.println("The number is not prime divisibleBy"+divisibleBy);
		}
		
	}

}
