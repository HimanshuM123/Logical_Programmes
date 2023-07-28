package number;

public class EmirpNumber {
	public static void main(String[] args) {
		int num = 13;
		if(isPrime(reverse(num))) {
			System.out.println("The number is Emirp number");
		}else {
			System.out.println("The number is NOT Emirp number");	
		}

	}

	private static boolean isPrime(int num) {
		boolean flag = true;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				flag = false;
			}
		}
		return flag;
	}
	
	private static int reverse(int num) {
		int result=0;
		while(num>0) {
			result = result*10+num%10;
			num =num /10;
		}
		return result;
	}
}
